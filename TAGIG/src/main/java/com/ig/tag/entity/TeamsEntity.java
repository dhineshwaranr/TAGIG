package com.ig.tag.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="teams")
public class TeamsEntity {

	@Id
	@GeneratedValue
	private int id;
	private String teamName;
	private String teamCode;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="teamsProjectsMapping",joinColumns=@JoinColumn(name="teamId",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="projectId",referencedColumnName="id"))
	private List<ProjectsEntity> projects;
	
	public List<ProjectsEntity> getProjects() {
		return projects;
	}
	public void setProjects(List<ProjectsEntity> projects) {
		this.projects = projects;
	}
		
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getTeamCode() {
		return teamCode;
	}
	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
	}
	
	
	
}
