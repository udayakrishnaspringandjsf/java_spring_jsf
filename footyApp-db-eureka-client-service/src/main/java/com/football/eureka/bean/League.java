package com.football.eureka.bean;

public class League extends FootballBeanData {

	private String federation;

	private String identifier;

	private String leagueSlug;

	private String nation;

	private String level;

	private String name;

	private Boolean cup;

	
	
	public League(String federation, String identifier, String leagueSlug, String nation, String level, String name,
			Boolean cup) {
		this.federation = federation;
		this.identifier = identifier;
		this.leagueSlug = leagueSlug;
		this.nation = nation;
		this.level = level;
		this.name = name;
		this.cup = cup;
	}

	public String getFederation() {
		return federation;
	}

	public void setFederation(String federation) {
		this.federation = federation;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getLeagueSlug() {
		return leagueSlug;
	}

	public void setLeagueSlug(String leagueSlug) {
		this.leagueSlug = leagueSlug;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getLevel() {
		return level;
	}

	public void setLevel(String level) {
		this.level = level;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Boolean getCup() {
		return cup;
	}

	public void setCup(Boolean cup) {
		this.cup = cup;
	}

}