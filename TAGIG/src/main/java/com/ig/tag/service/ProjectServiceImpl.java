package com.ig.tag.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;

import com.ig.tag.repository.ProjectRepository;
import com.ig.tag.repository.TeamRepository;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository projectsRepository;
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Override
	public List<ProjectsEntity> getAllProjects() {
		System.out.println("--2->");
		List<ProjectsEntity> p = projectsRepository.findAll();
		System.out.println(p);
		return p;
	}

	@Override
	public List<ProjectDTO> getAllProjectsByTeamId(TeamsEntity team) {
		List<ProjectsEntity> te = new ArrayList<ProjectsEntity>();
		List<ProjectDTO> pdto = new ArrayList<ProjectDTO>();
		try{
			te = projectsRepository.findAllByTeam(team);
			for(ProjectsEntity t : te){
				ProjectDTO projectDto = new ProjectDTO();
				projectDto.setProjectId(t.getId());
				projectDto.setProjectCode(t.getProjectCode());
				projectDto.setProjectName(t.getProjectName());
				pdto.add(projectDto);
			}
		}catch(Exception e){
			System.out.println(e);
		}
		return pdto;
	}

	@Override
	public ProjectsEntity getByTeamProject(String teamId, String projectId) {
		int project = Integer.parseInt(projectId);
		int team = Integer.parseInt(teamId);
		ProjectsEntity p = projectsRepository.findById(project);
		TeamsEntity t = teamRepository.findById(team);
		ProjectsEntity o = projectsRepository.findAllByTeamAndProject(team, project);
		return o;
	}

}
