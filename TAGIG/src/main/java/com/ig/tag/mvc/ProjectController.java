package com.ig.tag.mvc;

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

import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;
import com.ig.tag.service.ProjectServiceImpl;

@Controller
public class ProjectController {
	
	@Autowired
	private ProjectServiceImpl projectService;
	
	@RequestMapping(value="/addProject",method=RequestMethod.POST)
	@ResponseBody
	public String addProject(@ModelAttribute ProjectsEntity project){
		System.out.println(project.getProjectName());
		return "Success";
	}
	
	@RequestMapping(value="/getAllProjects",method=RequestMethod.GET)
	@ResponseBody
	public List<ProjectsEntity> getAllProjects(){
		List<ProjectsEntity> getAllprojects = null;
		try{
			System.out.println("-1-->");
			getAllprojects = projectService.getAllProjects();
		}catch(Exception e){
			System.out.println(e);
		}
		return getAllprojects;
	}
	
	@RequestMapping(value="getByProject_Team/{teamId}/{projectId}",method=RequestMethod.GET)
	@ResponseBody
	public ProjectsEntity getByProjectTeam(
			@PathVariable(value="teamId") String teamId,
			@PathVariable(value="projectId") String projectId){
			
		ProjectsEntity pe = projectService.getByTeamProject(teamId, projectId);
		System.out.println(pe.getProjectCode());
		for(TeamsEntity te : pe.getTeam()){
			System.out.println(te.getTeamName());
		}
		
		return null;
	}
}
