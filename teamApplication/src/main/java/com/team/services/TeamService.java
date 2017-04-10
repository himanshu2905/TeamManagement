package com.team.services;

import java.util.List;

import com.team.domain.Team;

public interface TeamService {

	public void createTeam(Team t);

	public void updateTeam(Team t);
	
	public List<Team>loadAll();
	
	public void deleteTeam(long id);
	
	public Team getTeamById(long id);

}
