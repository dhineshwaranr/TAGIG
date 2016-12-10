package com.ig.tag.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ig.jsonviews.JsonViews;

@Entity
@Table(name="team")
public class TeamEntity {
	
	@Id
	@GeneratedValue
	@Column(name="teamId")
	@JsonView(JsonViews.User.class)
	private int id;
	
	@JsonView(JsonViews.User.class)
	private String teamName;
	
	@JsonView(JsonViews.User.class) 
	private String teamCode;
	
	 
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "team")
	private List<UserEntity> users;
	
	
	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ProjectEntity> projects;

	public String getTeamCode() {
		return teamCode;
	}

	public void setTeamCode(String teamCode) {
		this.teamCode = teamCode;
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

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	
	
}
