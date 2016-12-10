package com.ig.tag.mvc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.dto.TeamsDTO;
import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;
import com.ig.tag.entity.UserEntity;
import com.ig.tag.repository.ProjectRepository;
import com.ig.tag.service.ProjectServiceImpl;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@RequestMapping(value="/project",method=RequestMethod.POST)
	@ResponseBody
	public String addProject(@ModelAttribute ProjectEntity project){
		try{
			projectRepo.save(project);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}	
	
	@RequestMapping(value="/getProject/{projectId}",method=RequestMethod.GET)
	@ResponseBody
	public String getProject(@PathVariable(value="projectId") String projectId){
		ProjectEntity project = projectRepo.findById(Integer.parseInt(projectId));
		System.out.println(project.getProjectName());
		for(UserEntity ue : project.getUsers()){
			System.out.println(ue.getName());
		}
		for(TeamEntity te : project.getTeams()){
			System.out.println(te.getTeamName());
		}
		return "Success";
	}
}
