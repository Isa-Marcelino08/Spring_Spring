package com.example.isakusmitsch.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.isakusmitsch.entities.Project;
import com.example.isakusmitsch.service.ProjectService;


@RestController
@RequestMapping("/project")
public class ProjectController {

	private final ProjectService projectService;
	
	@Autowired
	public ProjectController(ProjectService projectService) {
		this.projectService = projectService;
	}
	
	
	@PostMapping("/create")
	public Project createProject( @RequestBody Project project) {
		return projectService.saveProjects(project);
	}
	
	@GetMapping("/{id}")
	public Project getproject(@PathVariable Long id) {
		return projectService.findProjectByid(id);
	}
	
	@GetMapping("/all")
	public List<Project> getAllProjects(){
		return projectService.findAllProjects();
	}
}
