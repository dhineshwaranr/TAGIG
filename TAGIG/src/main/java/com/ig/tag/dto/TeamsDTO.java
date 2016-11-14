package com.ig.tag.dto;

import java.util.List;

import com.ig.tag.entity.ProjectsEntity;

public class TeamsDTO extends BaseResponseDTO{

	private int teamid;
	private String teamCode;
	private String teamName;
	private int teamCount;
	private List<ProjectDTO> projects;
	
	
	public int getTeamid() {
		return teamid;
	}
	public void setTeamid(int teamid) {
		this.teamid = teamid;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getTeamCount() {
		return teamCount;
	}
	public void setTeamCount(int teamCount) {
		this.teamCount = teamCount;
	}
	public List<ProjectDTO> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectDTO> projects) {
		this.projects = projects;
	}
	
	
	
}
