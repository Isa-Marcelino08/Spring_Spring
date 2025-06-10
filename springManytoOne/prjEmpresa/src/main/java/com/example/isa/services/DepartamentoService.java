package com.example.isa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.isa.Repositories.DepartamentoRepository;
import com.example.isa.entities.Departamento;


@Service
public class DepartamentoService {
	
	
private DepartamentoRepository departamentoRepository;

@Autowired
private DepartamentoService(DepartamentoRepository departamentoRepository) {
	this.departamentoRepository=departamentoRepository;
	
}

public Departamento getDepartamentoByid(Long id) {
	return departamentoRepository.findById(id).orElse(null);
}
 
  public List<Departamento> getAllDepartamentos(){
	  return departamentoRepository.findAll();
	  
  }
  
  public Departamento saveDepartamento(Departamento departamento) {
	  return departamentoRepository.save(departamento);
  }
}


