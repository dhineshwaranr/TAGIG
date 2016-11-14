package com.ig.tag.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="user")
public class UserEntity {

	@Id
	@GeneratedValue
	private int id;
	@NotNull
	private String userName;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String password;
	@NotNull
	private String conformPassword;
	@NotNull
	private String emailId;
	@NotNull
	private String gender;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="userProjectsMapping",joinColumns=@JoinColumn(name="userId",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="projectId",referencedColumnName="id"))
	private Set<ProjectsEntity> projects;
	
	@ManyToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinTable(name="userRoleMapping",joinColumns=@JoinColumn(name="userId",referencedColumnName="id"),inverseJoinColumns=@JoinColumn(name="roleId",referencedColumnName="id"))
	private Set<RolesEntity> roles;
	
	/*@OneToMany(targetEntity=TeamsEntity.class,mappedBy="user")
    private TeamsEntity userTeam;
	
	
	public TeamsEntity getUserTeam() {
		return userTeam;
	}

	public void setUserTeam(TeamsEntity userTeam) {
		this.userTeam = userTeam;
	}
*/
	public Set<RolesEntity> getRoles() {
		return roles;
	}

	public void setRoles(Set<RolesEntity> roles) {
		this.roles = roles;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}



	public String getLastName() {
		return lastName;
	}



	public void setLastName(String lastName) {
		this.lastName = lastName;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public String getConformPassword() {
		return conformPassword;
	}



	public void setConformPassword(String conformPassword) {
		this.conformPassword = conformPassword;
	}



	public String getEmailId() {
		return emailId;
	}



	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}



	public String getGender() {
		return gender;
	}



	public void setGender(String gender) {
		this.gender = gender;
	}



	public Set<ProjectsEntity> getProjects() {
		return projects;
	}



	public void setProjects(Set<ProjectsEntity> projects) {
		this.projects = projects;
	}



	public UserEntity(){
		
	}
}
