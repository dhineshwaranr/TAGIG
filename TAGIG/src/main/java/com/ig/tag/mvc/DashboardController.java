package com.ig.tag.mvc;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ig.tag.dto.BaseResponseDTO;
import com.ig.tag.dto.UserDTO;
import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.UserEntity;
import com.ig.tag.service.ProjectServiceImpl;
import com.ig.tag.service.UserService;
import com.ig.tag.service.UserServiceImpl;

@Controller
@RequestMapping("/superadmin")
public class DashboardController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private ProjectServiceImpl projectServiceImple;
	
	@RequestMapping(value="/getAllUser",method=RequestMethod.GET)
	@ResponseBody
	public List<UserEntity> getAllUsers(){
		List<UserEntity> getAllUsers = userServiceImpl.getAllUsers(); 
		return getAllUsers;
	}
	
	@RequestMapping(value="/getAllProjects",method=RequestMethod.GET)
	@ResponseBody
	public List<ProjectsEntity> getAllProjects(){
		List<ProjectsEntity> getAllprojects = null;
		try{
			System.out.println("-1-->");
			getAllprojects = projectServiceImple.getAllProjects();
		}catch(Exception e){
			System.out.println(e);
		}
		return getAllprojects;
	}
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	@ResponseBody
	public UserDTO registerUser(@RequestParam Map<String,String> allParameters){
		return userServiceImpl.registerUser(allParameters);
	}
}
