package com.football.eureka.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.football.eureka.entity.LeagueEntity;

@Repository
public interface FootballLeagueService extends JpaRepository<LeagueEntity, Integer> {

	/*@Query("FROM LeagueEntity l where l.nation = :nation")
	public List<LeagueEntity> findLeagueByNation(String nation);*/
	List<LeagueEntity> findByNation(String nation);
	
	public List<LeagueEntity> findAll();
}
