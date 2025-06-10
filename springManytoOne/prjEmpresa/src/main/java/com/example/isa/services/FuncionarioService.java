package com.example.isa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.Repositories.FuncionarioRepository;
import com.example.isa.entities.Funcionario;


@Service
public class FuncionarioService {

	
	private FuncionarioRepository funcionarioRepository;

	@Autowired
	private FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository=funcionarioRepository;
		
	}

	public Funcionario getFuncionarioByid(Long id) {
		return funcionarioRepository.findById(id).orElse(null);
	}
	 
	  public List<Funcionario> getAllFuncionario(){
		  return funcionarioRepository.findAll();
		  
	  }
	  
	  public Funcionario saveFuncionario(Funcionario funcionario) {
		  return funcionarioRepository.save(funcionario);
	  }
}
