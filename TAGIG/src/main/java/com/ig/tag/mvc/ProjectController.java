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
	public ArrayList<ProjectDTO> getAllProjects(){
		List<ProjectsEntity> getAllprojects = null;
		ArrayList<ProjectDTO> allProjects = new ArrayList<ProjectDTO>();
		try{
			getAllprojects = projectService.getAllProjects();
			for(ProjectsEntity pe : getAllprojects){
				ProjectDTO projectDto = new ProjectDTO();
				projectDto.setProjectId(pe.getId());
				projectDto.setProjectCode(pe.getProjectCode());
				projectDto.setProjectName(pe.getProjectName());
				List<TeamsEntity> teamEntity = pe.getTeam();
				List<TeamsDTO> allteams = new ArrayList<TeamsDTO>();
				for(TeamsEntity te : teamEntity){
					TeamsDTO teamDto = new TeamsDTO();
					teamDto.setTeamid(te.getId());
					teamDto.setTeamName(te.getTeamName());
					allteams.add(teamDto);
				}
				projectDto.setTeams(allteams);
				allProjects.add(projectDto);
			}
			
		}catch(Exception e){
			System.out.println(e);
		}
		return allProjects;
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
