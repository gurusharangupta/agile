package com.env.agile.service;

import java.util.List;

import com.env.agile.model.Project;

public interface ProjectService {

	
	public List<Project> listOfProjects();

	public void addProject(String userName, Project project);
}
