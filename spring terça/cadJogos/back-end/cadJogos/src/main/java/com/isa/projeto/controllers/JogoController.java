package com.isa.projeto.controllers;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.isa.projeto.entities.Jogo;
import com.isa.projeto.repositories.JogoRepository;
import com.isa.projeto.services.JogoService;

@RestController
@RequestMapping("/jogos")
public class JogoController {
	
	private final JogoRepository jogoRepository;
	private final JogoService jogoService;

	@Autowired
	public JogoController(JogoService jogoService,JogoRepository jogoRepository ) {
		this.jogoService = jogoService;
		this.jogoRepository = jogoRepository;
	}
	
	@GetMapping("/home")
	public String paginaInicial() {
		return "index";
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Jogo> Jogo (@PathVariable Long id) {
		Jogo jogo = jogoService.getJogoById(id);
		
		if (jogo != null) {
			return ResponseEntity.ok(jogo);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public List<Jogo> buscarTodosJogos (){
		return jogoService.getJogos();
	}
	
	@DeleteMapping(value="/{id}", consumes = {"multipart/form-data"})
	public void excluirJogo (@PathVariable Long id) {
		jogoService.deleteJogo(id);
	}
	
	@PostMapping("/create")
	public Jogo createJogo(@RequestParam("name") String name,
		@RequestParam("platform") String platform,
		@RequestParam("price")double price,
		@RequestParam("category") String category,
		@RequestParam("thumbnail") MultipartFile thumbnail) throws IOException {
	 byte[] imageBytes = thumbnail.getBytes();
	Jogo jogo  = new Jogo();
	jogo.setName(name);
	jogo.setPrice(price);
	jogo.setCategory(category);
	jogo.setPlatform(platform);
	jogo.setThumbnail(imageBytes);
	return jogoService.saveJogo(jogo);
	
	} 
	
	@PutMapping( value = "/{id}", consumes = { "multipart/form-data" })
	public Jogo updateJogo(@PathVariable Long id,
			@RequestPart("name") String name,
			@RequestPart("platform") String platform,
			@RequestPart("price") double price,
			@RequestPart("category") String category,
			@RequestPart(value = "thumbnail", required = false) MultipartFile thumbnail) {
		Jogo jogoAtualizado = new Jogo();
		jogoAtualizado.setName(name);
		jogoAtualizado.setPlatform(platform);
		jogoAtualizado.setPrice(price);
		jogoAtualizado.setCategory(category);
		
		
	    return jogoService.updateJogo(id, jogoAtualizado, thumbnail);
	}
			
	
	 
	
}
