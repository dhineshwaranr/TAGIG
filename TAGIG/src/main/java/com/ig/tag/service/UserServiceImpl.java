package com.ig.tag.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.entity.UserEntity;
import com.ig.tag.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public List<UserEntity> getAllUsers() {
		List<UserEntity> userList = userRepository.findAll();
		return userList;
	}

}
