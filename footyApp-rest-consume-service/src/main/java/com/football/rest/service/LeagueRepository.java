package com.football.rest.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.rest.entity.LeagueEntity;

@Repository
public interface LeagueRepository extends JpaRepository<LeagueEntity, Integer> {
  public LeagueEntity save(LeagueEntity leagueEntity);
  public List<LeagueEntity> findAll();
}
	

