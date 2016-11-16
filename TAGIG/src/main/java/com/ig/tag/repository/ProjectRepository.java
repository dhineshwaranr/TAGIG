package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;

@Repository
public interface ProjectRepository extends JpaRepository<ProjectsEntity, Long> {

	public List<ProjectsEntity> findAll();
	public ProjectsEntity findById(int id);
	public List<ProjectsEntity> findAllByTeam(TeamsEntity team);
	
	//@Query(value = "SELECT * FROM ProjectsEntity where id = 1", nativeQuery=true)
	//public ProjectsEntity findAllByProjectAndTeam(ProjectsEntity p, TeamsEntity t);
	
	//@Query(value = "SELECT * FROM projects where team =?1 AND id =?2", nativeQuery=true)
	//public ProjectsEntity findByTeamAndId(TeamsEntity t, int p);
	
	//@Query(value="select * from projects as p JOIN teams as t on (p.id = ?1 and t.id = ?2)", nativeQuery=true)
	//@Query(value = "select * FROM teams t JOIN projects p ON t.id = ?1 AND p.id=?2", nativeQuery=true)
	//@Query(value = "SELECT * FROM teams t JOIN projects p where t.id=?1 AND p.id =?2", nativeQuery=true)
	//@Query(value = "SELECT * FROM teams t JOIN projects p ON p.id = t.id where t.id = ?1 AND p.id = ?2", nativeQuery=true)
	@Query(value = "SELECT * FROM projects p where p.id = ?2 AND p.teams = ?1", nativeQuery=true)
	public ProjectsEntity findAllByTeamAndProject( int team, int project);
	
}



