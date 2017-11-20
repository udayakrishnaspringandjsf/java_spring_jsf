package com.football.eureka.bean;

public class Team extends FootballBeanData {


private String identifier;

private String teamSlug;

private String name;

private String flag;

private String notes;

private String teamFoundation;

private String teamWebsite;

private String leagueSlug;


public Team(String identifier, String teamSlug, String name, String flag, String notes, String teamFoundation,
		String teamWebsite,String leagueSlug) {
	this.identifier = identifier;
	this.teamSlug = teamSlug;
	this.name = name;
	this.flag = flag;
	this.notes = notes;
	this.teamFoundation = teamFoundation;
	this.teamWebsite = teamWebsite;
	this.leagueSlug=leagueSlug;
}

public String getIdentifier() {
return identifier;
}

public void setIdentifier(String identifier) {
this.identifier = identifier;
}

public String getTeamSlug() {
return teamSlug;
}

public void setTeamSlug(String teamSlug) {
this.teamSlug = teamSlug;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getFlag() {
return flag;
}

public void setFlag(String flag) {
this.flag = flag;
}

public String getNotes() {
return notes;
}

public void setNotes(String notes) {
this.notes = notes;
}

public String getTeamFoundation() {
return teamFoundation;
}

public void setTeamFoundation(String teamFoundation) {
this.teamFoundation = teamFoundation;
}

public String getTeamWebsite() {
return teamWebsite;
}

public void setTeamWebsite(String teamWebsite) {
this.teamWebsite = teamWebsite;
}

public String getLeagueSlug() {
	return leagueSlug;
}

public void setLeagueSlug(String leagueSlug) {
	this.leagueSlug = leagueSlug;
}

}