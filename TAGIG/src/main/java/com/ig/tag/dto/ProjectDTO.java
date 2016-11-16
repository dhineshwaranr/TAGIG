package com.ig.tag.dto;

import java.util.List;

public class ProjectDTO {
	
	private int projectId;
	private String projectCode;
	private String projectName;
	private List<TeamsDTO> teams;
	
	public int getProjectId() {
		return projectId;
	}
	public List<TeamsDTO> getTeams() {
		return teams;
	}
	public void setTeams(List<TeamsDTO> teams) {
		this.teams = teams;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	

}
