package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectsEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectsEntity, Long> {

	public List<ProjectsEntity> findAll();
	
}
