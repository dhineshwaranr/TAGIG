package com.ig.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;
import com.ig.tag.repository.TeamRepository;

@Service
public class TeamServiceImpl implements TeamServices {

	@Autowired
	private TeamRepository teamRepository; 
	
	@Override
	public void addTeam(TeamsEntity team) {
		teamRepository.save(team);
	}

	@Override
	public List<TeamsEntity> getAllTeams() {
		return teamRepository.findAll();
	}

	@Override
	public TeamsEntity getByTeamProject(String teamId, String projectId) {
		int project = Integer.parseInt(projectId);
		int team = Integer.parseInt(teamId);
		TeamsEntity o = teamRepository.findAllByTeamAndProject(team, project);
		System.out.println(o.getTeamName());
		for(ProjectsEntity p : o.getProjects()){
			System.out.println(p.getProjectCode());
		}
		return o;
	}

	@Override
	public TeamsEntity findByTeamId(int team) {
		TeamsEntity te = teamRepository.findById(team);
		return te;
	}

}
