package com.ig.tag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;

import com.ig.tag.repository.ProjectRepository;
import com.ig.tag.repository.TeamRepository;

@Service
public class ProjectServiceImpl{

	@Autowired
	private ProjectRepository projectsRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	public List<ProjectEntity> getAllProjects() {
		System.out.println("--2->");
		List<ProjectEntity> p = projectsRepository.findAll();
		System.out.println(p);
		return p;
	}
	
}
