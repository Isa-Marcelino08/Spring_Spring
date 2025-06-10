package com.example.isa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.Repositories.DependenteRepository;
import com.example.isa.entities.Dependente;


@Service
public class DependenteService {

	
	private DependenteRepository dependenteRepository;

	@Autowired
	private DependenteService(DependenteRepository dependenteRepository) {
		this.dependenteRepository=dependenteRepository;
		
	}

	public Dependente getDependenteByid(Long id) {
		return dependenteRepository.findById(id).orElse(null);
	}
	 
	  public List<Dependente> getAllDependente(){
		  return dependenteRepository.findAll();
		  
	  }
	  
	  public Dependente saveDependente(Dependente dependente) {
		  return dependenteRepository.save(dependente);
	  }
}
