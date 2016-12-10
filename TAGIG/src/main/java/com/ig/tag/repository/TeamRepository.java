package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;
import com.ig.tag.entity.UserEntity;


@Repository
public interface TeamRepository extends JpaRepository<TeamEntity, Long> {

	public TeamEntity findById(int teamId);
	public TeamEntity findByProjects(ProjectEntity project);
	public List<TeamEntity> findByUsersAndProjects(UserEntity user, ProjectEntity project);
	
	
}
