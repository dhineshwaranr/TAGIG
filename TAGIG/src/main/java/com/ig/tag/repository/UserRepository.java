package com.ig.tag.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ig.tag.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>  {

	public List<UserEntity> findAll();
	
}
