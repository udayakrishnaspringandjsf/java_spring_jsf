/**
 * 
 */
package com.football.mbeans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.football.entity.Country;
import com.football.entity.LeagueType;
import com.football.service.CountryService;
import com.football.service.LeagueService;

@Named

/**
 * @author hp
 *
 */
@RequestScoped
public class LeagueMBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3036429563419806140L;
	private List<SelectItem> options = new ArrayList<>();
	private List<Country> leagueCountryList = new ArrayList<>();
	@Inject
	private CountryService countryService;// ;=new CountryServiceImpl();
	@Inject
	private LeagueService leagueService;

	private LeagueType league = new LeagueType();
	private String leagueName;
	private String leagueCountry;
	private String aliasName;
	private int leagueId;
	private List<LeagueType> leagueList;
	private List<String> leagueNameList=new ArrayList<>();

	/**
	 * 
	 */
	public LeagueMBean() {
		// TODO Auto-generated constructor stub

	}

	@PostConstruct
	void initCountries() {
		leagueList=leagueService.retriveAllLeagues();
		for(LeagueType league:leagueList){
			leagueNameList.add(league.getLeagueName());
		}
		leagueCountryList = countryService.getAllCountries();
		for (Country c : leagueCountryList)
			options.add(new SelectItem(c.getCountryName()));
		
		
	}

	public List<SelectItem> getOptions() {
		return options;
	}

	public void setOptions(List<SelectItem> options) {
		this.options = options;
	}

	public List<Country> getLeagueCountryList() {
		// leagueCountryList=countryService.getAllCountries();
		return leagueCountryList;
	}

	public void setLeagueCountryList(List<Country> leagueCountryList) {
		this.leagueCountryList = leagueCountryList;
	}

	public CountryService getCountryService() {
		return countryService;
	}

	public void setCountryService(CountryService countryService) {
		this.countryService = countryService;
	}

	public LeagueType getLeague() {
		return league;
	}

	public void setLeague(LeagueType league) {
		this.league = league;
	}

	public int getLeagueId() {
		return this.leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getLeagueCountry() {
		return this.leagueCountry;
	}

	public void setLeagueCountry(String leagueCountry) {
		this.leagueCountry = leagueCountry;
	}

	public String getLeagueName() {
		return this.leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	
	
	public LeagueService getLeagueService() {
		return leagueService;
	}

	public void setLeagueService(LeagueService leagueService) {
		this.leagueService = leagueService;
	}

	public List<LeagueType> getLeagueList() {
		return leagueList;
	}

	public void setLeagueList(List<LeagueType> leagueList) {
		this.leagueList = leagueList;
	}
	

	public List<String> getLeagueNameList() {
		return leagueNameList;
	}

	public void setLeagueNameList(List<String> leagueNameList) {
		this.leagueNameList = leagueNameList;
	}

	public void saveLeague() {

		league.setLeagueName(leagueName);
		league.setLeagueCountry(leagueCountry);
		if (league.getAliasName() != null) {
			league.setAliasName(aliasName);
		}
		else{
			league.setAliasName(aliasName);
		}
		leagueService.saveLeague(league);
		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, "League " + leagueName + " Saved ", null);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("League " + leagueName + " Saved "));

	}
	public String cancel(){
		return null;
	}
	

}
