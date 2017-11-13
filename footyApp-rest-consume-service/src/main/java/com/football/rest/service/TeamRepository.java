package com.football.rest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.football.rest.entity.TeamEntity;

public interface TeamRepository extends JpaRepository<TeamEntity, Integer> {

	@SuppressWarnings("unchecked")
	public TeamEntity save(TeamEntity teamEntity);
	 @Query("SELECT t.name FROM TeamEntity t where t.leagueSlug = :slug")   
	public List<String> findTeamBySlug(@Param ("slug")String slug);
		
}
