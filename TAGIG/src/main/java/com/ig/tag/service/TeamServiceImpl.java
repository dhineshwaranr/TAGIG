package com.ig.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;
import com.ig.tag.repository.TeamRepository;

@Service
public class TeamServiceImpl {

	@Autowired
	private TeamRepository teamRepository; 
	
	public List<TeamEntity> readAllTeams() {
		return teamRepository.findAll();
	}

}
