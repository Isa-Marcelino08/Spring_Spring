package com.example.isa.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isa.entities.Funcionario;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
