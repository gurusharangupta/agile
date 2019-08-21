package com.env.agile.service;

import java.util.List;
import java.util.Set;

import com.env.agile.exception.ResourceNotFoundException;
import com.env.agile.model.Project;

public interface ProjectService {

	
	public List<Project> listOfProjects(String userName);

	public void addProject(String userName, Project project) throws ResourceNotFoundException;

	public void addTeamMembers(Project project);
}
