package com.ig.tag.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.ig.jsonviews.CustomTeamSerializer;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.ig.jsonviews.JsonViews;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@GeneratedValue
	@JsonView(JsonViews.User.class)
	@Column(name="userId")
	private int id;
	
	@JsonView(JsonViews.User.class)
	private String name;
	
	//@JsonSerialize(using = CustomTeamSerializer.class)
	@JsonView(JsonViews.User.class)
	@ManyToOne(cascade = CascadeType.ALL)
	private TeamEntity team;
	
	@JsonView(JsonViews.User.class)
	@ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	private List<ProjectEntity> projects;
	
	@JsonView(JsonViews.User.class)
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name="userRole")
	private RoleEntity role;
	
	@JsonView(JsonViews.User.class)
	private String color;
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TeamEntity getTeam() {
		return team;
	}

	public void setTeam(TeamEntity team) {
		this.team = team;
	}

	public List<ProjectEntity> getProjects() {
		return projects;
	}

	public void setProjects(List<ProjectEntity> projects) {
		this.projects = projects;
	}
	
}

