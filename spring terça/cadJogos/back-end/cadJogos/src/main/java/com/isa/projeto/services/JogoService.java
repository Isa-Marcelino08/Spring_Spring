package com.isa.projeto.services;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.isa.projeto.entities.Jogo;
import com.isa.projeto.repositories.JogoRepository;

@Service
public class JogoService {

	private final JogoRepository jogoRepository;
	
	@Autowired
	public JogoService(JogoRepository jogoRepository) {
		this.jogoRepository = jogoRepository;
	}
	
	public Jogo saveJogo (Jogo jogo) {
		return jogoRepository.save(jogo);
	}
	
	public Jogo getJogoById (Long id) {
		return jogoRepository.findById(id).orElse(null);
	}
	
	public List<Jogo> getJogos (){
		return jogoRepository.findAll();
	}
	
	public void deleteJogo(Long Id) {
		 jogoRepository.deleteById(Id);
	}
	
	 
    public Jogo updateJogo(Long id, Jogo novoJogo, MultipartFile thumbnail) {
    	Optional<Jogo> jogoOptional = jogoRepository.findById(id);
    	if(jogoOptional.isPresent()) {
    		Jogo jogoExistente = jogoOptional.get();
    		jogoExistente.setName(novoJogo.getName());
    		jogoExistente.setPlatform(novoJogo.getPlatform());
    		jogoExistente.setPrice(novoJogo.getPrice());
    		
    		jogoExistente.setCategory(novoJogo.getCategory());
    		
    		if(thumbnail != null && !thumbnail.isEmpty()) {
    			try {
    				byte[] imagemByte=thumbnail.getBytes();
    				jogoExistente.setThumbnail(imagemByte);
    			} catch(IOException e) {
    				throw new RuntimeException("Erro ao processar a imagem", e );
    			}
    			return jogoRepository.save(jogoExistente);
    		} else {
    			return null;
    	}
        
    	}
    	return null;
    }
}


