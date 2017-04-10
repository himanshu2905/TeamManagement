package com.team.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.team.domain.Team;
import com.team.services.TeamService;

@Controller
@RequestMapping("/team")
public class TeamController {

	@Autowired
	private TeamService teamService;
	//we need add all request methods now..
	
	@RequestMapping(value="/add", method=RequestMethod.GET)
	public ModelAndView loadAddPage(){
		ModelAndView mv = new ModelAndView("add");
		mv.addObject("team", new Team());
		return mv;
	}

	@RequestMapping(value="/edit/{id}", method=RequestMethod.GET)//{id} = path parameter
	public ModelAndView loadEditPage(@PathVariable Long id){
		ModelAndView mv = new ModelAndView("edit");
		mv.addObject("team", teamService.getTeamById(id));
		return mv;
	}

	@RequestMapping(value="/delete", method=RequestMethod.GET)//teamId=10(request param)
	@Secured("ROLE_ADMIN")
	public ModelAndView deleteTeam(@RequestParam("teamId") Long id){
		ModelAndView mv = new ModelAndView("home");
		teamService.deleteTeam(id);
		String message = "Team was successfully deleted";
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping(value="/create", method=RequestMethod.POST)
	public ModelAndView addTeam(@ModelAttribute Team team){
		ModelAndView mv = new ModelAndView("home");
		teamService.createTeam(team);
		String message = "Team was successfully added to the database";
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping(value="/update/{id}", method=RequestMethod.POST)
	public ModelAndView updateTeam(@ModelAttribute Team team, @PathVariable Long id){
		ModelAndView mv = new ModelAndView("home");
		team.setId(id);
		teamService.updateTeam(team);
		String message = "Team was successfully updated in the database";
		mv.addObject("message", message);
		return mv;
	}

	@RequestMapping(value="/list", method=RequestMethod.GET)
	public ModelAndView loadListPage(){
		ModelAndView mv = new ModelAndView("list");
		List<Team>teams = teamService.loadAll();
		mv.addObject("teams", teams);
		return mv;
	}
	
}
