package com.env.agile.repository;

import java.util.List;

import com.env.agile.model.Project;

public interface ProjectRepository{
	
	public List<Project> listOfProjects();
	public void addProject(Project project);

}
