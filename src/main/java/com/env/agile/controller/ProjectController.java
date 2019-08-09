package com.env.agile.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.Project;
import com.env.agile.model.UserToken;
import com.env.agile.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;

	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public String projects() {

		projectService.listOfProjects();
		return "Projects";
	}

	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken addProjects(@RequestHeader("Username") String userName, @RequestBody Project project)
			throws ResourceNotFoundException {
		UserToken _token = new UserToken();
		projectService.addProject(userName, project);
		_token.setMessage("Project Added successfully");
		return _token;
	}

}
