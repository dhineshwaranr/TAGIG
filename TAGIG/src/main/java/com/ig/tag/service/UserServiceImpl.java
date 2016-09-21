package com.ig.tag.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ig.tag.dto.BaseResponseDTO;
import com.ig.tag.dto.UserDTO;
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

	@Override
	public UserDTO registerUser(Map<String,String> allUserParameters) {
		Map<String, String> user = allUserParameters;
		List<String> params;
		List<UserEntity> userEntityFields = new ArrayList<UserEntity>();
		UserDTO userDTO = new UserDTO();
		for(Map.Entry<String, String> entry : user.entrySet()){
			System.out.println(entry.getKey() +":"+ entry.getValue());
			/*for(UserEntity ue : userEntityFields){
				if(entry.getKey().equalsIgnoreCase(ue.)){
					
				}
			}*/
		}
		userDTO.setFirstName("Dinesh");
		userDTO.setUserType("Employee");
		userDTO.setResponseCode(1);
		userDTO.setResponseMessage("Success");
		return userDTO;
	}
}
