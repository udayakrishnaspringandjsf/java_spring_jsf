package com.football.serviceimpl;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.football.entity.Country;
import com.football.service.CountryService;


@Stateless
public class CountryServiceImpl implements CountryService {

	@PersistenceContext(name = "FootyApp")
	private EntityManager em;
	@Override
	public List<Country> getAllCountries() {
		// TODO Auto-generated method stub
		List<Country> resultList = em.createNamedQuery("Country.findAll").getResultList();
		List<Country> countryList=resultList;
		return countryList;
	}

}
