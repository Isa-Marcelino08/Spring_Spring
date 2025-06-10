package com.example.isa.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.isa.entities.Funcionario;
import com.example.isa.services.FuncionarioService;

	
	@RestController
	@RequestMapping("/funcionarios") 
	public class FuncionarioController {
		
		 private final FuncionarioService funcionarioService;
		 
         public FuncionarioController (FuncionarioService funcionarioService) {
        	 this.funcionarioService = funcionarioService;
         }
         
         public ResponseEntity<Funcionario> findFuncionarioById (@PathVariable Long id) {
        	 Funcionario funcionario = funcionarioService.getFuncionarioByid(id);
        	 
        	 if(funcionario != null) {
        		 return ResponseEntity.ok(funcionario);
        	 } else{
        		  return ResponseEntity.notFound().build();
        	 }
         }
		 
         @GetMapping("/")
         public ResponseEntity<List<Funcionario>> findAllFuncionario(){
        	 List<Funcionario>funcionarios = funcionarioService.getAllFuncionario();
        	 return ResponseEntity.ok(funcionarios);
         }
         @PostMapping("/")
         public ResponseEntity<Funcionario> insertFuncionario(@RequestBody Funcionario funcionario) {
        	 Funcionario novofuncionario = funcionarioService.saveFuncionario(funcionario);
        	 return ResponseEntity.status(HttpStatus.CREATED).body(novofuncionario);
         }
	}
