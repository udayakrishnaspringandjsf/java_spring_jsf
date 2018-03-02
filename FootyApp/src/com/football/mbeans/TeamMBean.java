/**
 * 
 */
package com.football.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import javax.inject.Named;

import com.football.entity.Country;
import com.football.entity.LeagueType;
import com.football.service.CountryService;

@Named("TeamMBean")
@RequestScoped
/**
 * @author hp
 *
 */
public class TeamMBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7671984035178349427L;
	@Inject
	CountryService countryService;
	private List<SelectItem> options = new ArrayList<>();
	private List<Country> teamCountryList=new ArrayList<Country>();
	private String teamCountry;

	/**
	 * 
	 */
	public TeamMBean() {
		// TODO Auto-generated constructor stub
	}
	@PostConstruct
	void initCountries() {
		
		teamCountryList = countryService.getAllCountries();
		for (Country c : teamCountryList)
			options.add(new SelectItem(c.getCountryName()));
		
		
	}
	public CountryService getCountryService() {
		return countryService;
	}
	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}
	public List<SelectItem> getOptions() {
		return options;
	}
	public void setOptions(List<SelectItem> options) {
		this.options = options;
	}
	public List<Country> getTeamCountryList() {
		return teamCountryList;
	}
	public void setTeamCountryList(List<Country> teamCountryList) {
		this.teamCountryList = teamCountryList;
	}
	public String getTeamCountry() {
		return teamCountry;
	}
	public void setTeamCountry(String teamCountry) {
		this.teamCountry = teamCountry;
	}
	
	
	

}
