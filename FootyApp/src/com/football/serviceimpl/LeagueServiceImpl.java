package com.football.serviceimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.football.entity.LeagueType;
import com.football.service.LeagueService;

@Stateless
public class LeagueServiceImpl implements LeagueService {

	@PersistenceContext(name = "FootyApp")
	private EntityManager em;
	@Override
	public List<LeagueType> retriveAllLeagues() {
		// TODO Auto-generated method stub
		Query query=em.createNamedQuery("LeagueType.findAll");
		List<LeagueType> leagueList=query.getResultList();
		return leagueList;
	}

	@Override
	public void saveLeague(LeagueType league) {
		// TODO Auto-generated method stub
   em.persist(league);
	}

	@Override
	public Integer findLeagueByName(String name) {
		// TODO Auto-generated method stub
	return	em.createNamedQuery("LeagueType.findLeagueByName").setParameter("leagueName", name).getResultList().size();
	}

}
