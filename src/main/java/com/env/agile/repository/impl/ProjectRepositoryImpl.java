package com.env.agile.repository.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.env.agile.model.Project;
import com.env.agile.repository.ProjectRepository;

@Repository
public class ProjectRepositoryImpl implements ProjectRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Project> listOfProjects(String username) {
		Query query  = entityManager.createQuery("select projects from User where username like :username");
		query.setParameter("username", username);
		List<Project> projects = (List<Project>)query.getResultList();
		
		return projects;
	}

	@Override
	public void addProject(Project project) {
		entityManager.persist(project);
		
	}

	@Override
	public void saveTeamMembers(Project project) {
		Query query  = entityManager.createQuery("from Project where project_id like :id");
		query.setParameter("id", project.getId());
		Project persistentProject = (Project)query.getResultList().get(0);
		if(persistentProject != null){
			persistentProject.setTeamMembers(project.getTeamMembers());
		}
		entityManager.persist(persistentProject);
		
	}

}
