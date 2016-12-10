package com.ig.tag.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;
import com.ig.jsonviews.JsonViews;

@Entity
@Table(name="role")
public class RoleEntity {

	@Id
	@GeneratedValue
	@Column(name="roleId")
	@JsonView(JsonViews.User.class)
	private int id;
	
	@JsonView(JsonViews.User.class)
	private String roleName;
	
	@OneToMany(mappedBy="role", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<UserEntity> user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public List<UserEntity> getUser() {
		return user;
	}

	public void setUser(List<UserEntity> user) {
		this.user = user;
	}



		
	
		
}
