package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;
import com.ig.tag.entity.UserEntity;


@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>  {

	public UserEntity save(UserEntity user);
	public UserEntity findById(int userId);
	public List<UserEntity> findAll();
	public List<UserEntity> findByTeam(TeamEntity team);
	public List<UserEntity> findByProjectsAndTeam(ProjectEntity project, TeamEntity team);
	
}
