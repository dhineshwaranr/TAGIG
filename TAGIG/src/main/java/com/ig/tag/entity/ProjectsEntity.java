package com.ig.tag.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="projects")
public class ProjectsEntity {
	
	@Id
	private int id;
	@NotNull
	private String projectName;
	@NotNull
	private String projectCode;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="teamsProjectsMapping",joinColumns=@JoinColumn(name="projectId",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="teamId",referencedColumnName="id"))
	private List<TeamsEntity> team;
	
	public List<TeamsEntity> getTeam() {
		return team;
	}

	public void setTeam(List<TeamsEntity> team) {
		this.team = team;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public ProjectsEntity(){
		
	}
}
