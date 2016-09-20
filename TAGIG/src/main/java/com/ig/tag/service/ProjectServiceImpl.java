package com.ig.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.repository.ProjectRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectsRepository;
	
	@Override
	public List<ProjectsEntity> getAllProjects() {
		System.out.println("--2->");
		return projectsRepository.findAll();
	}

}
