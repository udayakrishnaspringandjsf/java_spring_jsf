package com.football.eureka.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.eureka.entity.TeamEntity;
import java.lang.String;
import java.util.List;

@Repository
public interface FootballTeamService extends JpaRepository<TeamEntity, Integer> {

	
	List<TeamEntity> findTeamByLeagueSlug(String leagueSLug);
}
