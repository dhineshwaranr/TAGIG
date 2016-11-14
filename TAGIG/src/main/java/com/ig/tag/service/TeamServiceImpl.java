package com.ig.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
