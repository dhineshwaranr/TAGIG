package com.ig.tag.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;

@Repository
public interface TeamRepository extends JpaRepository<TeamsEntity, Long> {

	@SuppressWarnings("unchecked")
	public TeamsEntity save(TeamsEntity team);
	
	public TeamsEntity findById(int id);
	
}
