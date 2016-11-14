package com.ig.tag.service;

import java.util.List;

import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;

public interface ProjectService {

	public List<ProjectsEntity> getAllProjects();
	public List<ProjectDTO> getAllProjectsByTeamId(TeamsEntity team);
	public ProjectsEntity getByTeamProject(String teamId, String projectId);
}
