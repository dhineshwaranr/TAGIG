package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

	public ProjectEntity findById(int project);
	
}



