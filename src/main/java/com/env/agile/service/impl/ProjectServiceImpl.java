package com.env.agile.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.Project;
import com.env.agile.model.User;
import com.env.agile.repository.ProjectRepository;
import com.env.agile.repository.UserRepository;
import com.env.agile.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public List<Project> listOfProjects(String usernname) {
		return this.projectRepository.listOfProjects(usernname);
	}

	@Override
	public void addProject(String userName, Project project) throws ResourceNotFoundException {
		User user = this.userRepository.findUserByEmail(userName);
		if(user!= null){
		project.setUser(user);
		projectRepository.addProject(project);
		}else{
			
			throw new ResourceNotFoundException("Cant add project since user is not found or not authorized");
		}

	}

	@Override
	public void addTeamMembers(Project project) {
		projectRepository.saveTeamMembers(project);
		
	}

}
