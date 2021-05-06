package io.snehil.ipldashboard.repository;

import org.springframework.data.repository.CrudRepository;

import io.snehil.ipldashboard.model.Team;

public interface TeamRepository extends CrudRepository<Team, Long> {
	Team findByTeamName(String teamName);
}
