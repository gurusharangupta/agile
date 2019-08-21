package com.env.agile.repository;

import java.util.List;
import java.util.Set;

import com.env.agile.model.Project;

public interface ProjectRepository{
	
	public List<Project> listOfProjects(String username);
	public void addProject(Project project);
	public void saveTeamMembers(Project project);

}
