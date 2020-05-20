package com.env.agile.controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.kafka.producer.KafkaProducer;
import com.env.agile.model.Greetings;
import com.env.agile.model.Project;
import com.env.agile.model.TeamMember;
import com.env.agile.model.UserToken;
import com.env.agile.service.ProjectService;

@RestController
@RequestMapping("/projects")
public class ProjectController {

	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private KafkaProducer kafkaProducer;

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:4200")
	public List<Project> projects(@RequestHeader("Username") String userName) {
		return projectService.listOfProjects(userName);
	}

	@PostMapping("/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken addProjects(@RequestHeader("Username") String userName, @RequestBody Project project)
			throws ResourceNotFoundException {
		UserToken _token = new UserToken();
		
		
		projectService.addProject(userName, project);
		_token.setMessage("Project Added successfully");
		Greetings greeting = new Greetings("Created a project",userName);
		kafkaProducer.sendjsonMessage(greeting);
		_token.setResponse(ResponseEntity.ok().body(project));
		return _token;
	}
	
	@PostMapping("/teammembers/add")
	@CrossOrigin(origins = "http://localhost:4200")
	public UserToken addTeamMembers(@RequestHeader("Username") String userName, @RequestBody Project project)
			throws ResourceNotFoundException {
		UserToken _token = new UserToken();
		projectService.addTeamMembers(project);
		List<Project> projects = projectService.listOfProjects(userName);
		_token.setMessage("Team Members Added successfully");
		Greetings greeting = new Greetings("Added a team member",userName);
		kafkaProducer.sendjsonMessage(greeting);
		_token.setResponse(ResponseEntity.ok().body(projects));
		return _token;
	}

}
