package io.snehil.ipldashboard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.snehil.ipldashboard.model.Team;
import io.snehil.ipldashboard.repository.MatchRepository;
import io.snehil.ipldashboard.repository.TeamRepository;

@RestController
public class TeamController {
	private TeamRepository teamRepository;
	private MatchRepository matchRepository;
	
	public TeamController(TeamRepository teamRepository,MatchRepository matchRepository) {
		super();
		this.teamRepository = teamRepository;
		this.matchRepository = matchRepository;
	}

	@GetMapping("/team/{teamName}")
	public Team getTeam(@PathVariable String teamName)
	{
		Team team =  this.teamRepository.findByTeamName(teamName);
		team.setMatches(matchRepository.findLatestMatchesByTeam(teamName,4));
		return team;
	}
}
