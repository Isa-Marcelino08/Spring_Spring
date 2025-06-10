package com.example.isakusmitsch.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.isakusmitsch.entities.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
