package com.ig.tag.service;

import java.util.List;

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;

public interface TeamServices {

	public void addTeam(TeamsEntity team);
	public List<TeamsEntity> getAllTeams();
	public TeamsEntity getByTeamProject(String teamId, String projectId); 
	
}
