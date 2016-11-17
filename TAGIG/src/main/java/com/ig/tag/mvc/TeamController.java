package com.ig.tag.mvc;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.dto.TeamsDTO;
import com.ig.tag.entity.ProjectsEntity;
import com.ig.tag.entity.TeamsEntity;
import com.ig.tag.service.ProjectServiceImpl;
import com.ig.tag.service.TeamServiceImpl;

@Controller
public class TeamController {

	@Autowired
	private TeamServiceImpl teamService; 
	@Autowired
	private ProjectServiceImpl projectService;
	
	@RequestMapping(value="/addNewTeam" ,method=RequestMethod.POST)
	@ResponseBody
	public String addTeam(@ModelAttribute TeamsEntity team){
		teamService.addTeam(team);
		return "success";
	}
	
	@RequestMapping(value="/getAllTeams", method=RequestMethod.GET)
	@ResponseBody
	public List<TeamsDTO> getAllTeams(){
		List<TeamsEntity> teams = teamService.getAllTeams();
		List<ProjectDTO> teamProjectEntity = new ArrayList<ProjectDTO>();
		ArrayList<TeamsDTO> allTeamProjects = new ArrayList<TeamsDTO>();
		
		for(TeamsEntity t : teams){
			TeamsDTO teamDto = new TeamsDTO();
			teamDto.setTeamid(t.getId());
			teamDto.setTeamCode(t.getTeamCode());
			teamDto.setTeamName(t.getTeamName());
			teamDto.setTeamCount(10);
			teamDto.setResponseCode(1);
			teamProjectEntity = projectService.getAllProjectsByTeamId(t);
			teamDto.setProjects(teamProjectEntity);
			allTeamProjects.add(teamDto);
		}
		
		return allTeamProjects;
	}
	
	@RequestMapping(value="getByTeam_Projects/{teamId}/{projectId}",method=RequestMethod.GET)
	@ResponseBody
	public TeamsEntity getByTeamProject(
			@PathVariable(value="teamId") String teamId,
			@PathVariable(value="projectId") String projectId){
			
		TeamsEntity pe = teamService.getByTeamProject(teamId, projectId);
		//System.out.println(pe);
		/*for(TeamsEntity te : pe.getTeam()){
			System.out.println(te.getTeamName());
		}*/
		
		return null;
	}
	
	@RequestMapping(value="getByTeam/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	public TeamsEntity getByTeam(
			@PathVariable(value="teamId") String teamId){
		TeamsEntity pe = teamService.findByTeamId(Integer.parseInt(teamId));
		System.out.println("ffff");
		System.out.println(pe);
		return pe;
	}
}
