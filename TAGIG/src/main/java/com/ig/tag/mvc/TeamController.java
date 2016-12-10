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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.annotation.JsonView;
import com.ig.jsonviews.JsonViews;
import com.ig.tag.dto.ProjectDTO;
import com.ig.tag.dto.TeamsDTO;
import com.ig.tag.entity.ProjectEntity;
import com.ig.tag.entity.TeamEntity;
import com.ig.tag.entity.UserEntity;
import com.ig.tag.repository.TeamRepository;
import com.ig.tag.service.ProjectServiceImpl;
import com.ig.tag.service.TeamServiceImpl;


@Controller
public class TeamController {

	@Autowired
	private TeamServiceImpl teamService; 
	
	@Autowired
	private TeamRepository teamRepo;
	
	@RequestMapping(value="/team",method=RequestMethod.POST)
	@ResponseBody
	public String create(@ModelAttribute TeamEntity team){
		try{
			teamRepo.save(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	
	@RequestMapping(value="/team",method=RequestMethod.GET)
	@ResponseBody
	public List<TeamEntity> read(){
		List<TeamEntity> team = null;
		try{
			team = teamRepo.findAll();
			System.out.println(team.size());
		}catch(Exception e){
			System.out.println(e);
		}
		return team;
	}
	
	@RequestMapping(value="/team/{teamId}",method=RequestMethod.PUT)
	@ResponseBody
	public String update(@RequestParam("teamName") String teamName, @PathVariable(value="teamId") String teamId){
		try{
			TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
			team.setTeamName(teamName);
			TeamEntity t = teamRepo.save(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/team/{teamId}",method=RequestMethod.DELETE)
	@ResponseBody
	public String delete(@PathVariable(value="teamId") String teamId){
		try{
			TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
			teamRepo.delete(team);
		}catch(Exception e){
			System.out.println(e);
		}
		return "Success";
	}
	
	@RequestMapping(value="/getByUserProject/{userId}/{projectId}",method=RequestMethod.GET)
	@ResponseBody
	public String getByUserAndProject(@PathVariable(value="userId") UserEntity user, @PathVariable(value="projectId") ProjectEntity project){
		List<TeamEntity> p = teamRepo.findByUsersAndProjects(user, project);
		p.forEach(i -> System.out.println(i.getTeamName()));
		return "Success";
	}
	
	@RequestMapping(value="/getTeam/{teamId}",method=RequestMethod.GET)
	@ResponseBody
	public String getTeam(@PathVariable(value="teamId") String teamId){
		System.out.println("user: " +teamId);
		TeamEntity team = teamRepo.findById(Integer.parseInt(teamId));
		System.out.println(team.getTeamName());
		for(UserEntity ue : team.getUsers()){
			System.out.println(ue.getName());
		}
		return "Success";
	}
}
