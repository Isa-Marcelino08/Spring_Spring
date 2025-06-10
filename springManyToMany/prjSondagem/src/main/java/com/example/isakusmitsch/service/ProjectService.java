package com.example.isakusmitsch.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.isakusmitsch.entities.Project;
import com.example.isakusmitsch.repositories.ProjectRepository;

@Service
public class ProjectService {
	private final ProjectRepository projectRepository;
	
	
	public ProjectService(ProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	public Project findProjectByid(Long id) {
		Optional<Project> project = projectRepository.findById(id);
		return project.orElse(null);	
	}
	
	public List<Project> findAllProjects(){
		return projectRepository.findAll();
	}
	
	public Project saveProjects(Project project) {
		return projectRepository.save(project);
	}
}
