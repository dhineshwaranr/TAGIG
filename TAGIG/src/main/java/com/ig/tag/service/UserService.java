package com.ig.tag.service;

import java.util.List;
import java.util.Map;

import com.ig.tag.dto.BaseResponseDTO;
import com.ig.tag.dto.UserDTO;
import com.ig.tag.entity.UserEntity;

public interface UserService {

	public List<UserEntity> getAllUsers();
	public UserDTO registerUser(Map<String,String> allUserParameters);
	
}
