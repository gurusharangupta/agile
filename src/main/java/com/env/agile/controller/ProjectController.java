package com.env.agile.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	
	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public String projects() {
		
		return "Projects";
	}
	
}
