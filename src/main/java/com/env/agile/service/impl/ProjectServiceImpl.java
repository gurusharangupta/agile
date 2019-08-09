package com.env.agile.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.env.agile.model.Project;
import com.env.agile.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	/*@Autowired
	private UserRepository userRepository;

	@Autowired
	private ProjectRepository projectRepository;
*/
	@Override
	public List<Project> listOfProjects() {

		return null;
	}

	@Override
	public void addProject(String userName, Project project) {
		/*User user = this.userRepository.findUserByEmail(userName);
		
		project.setUser(user);
		projectRepository.addProject(project);*/

	}

}
