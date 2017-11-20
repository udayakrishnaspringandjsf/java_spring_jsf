package com.football.eureka;

public class Team extends FootballBeanData {


private String identifier;

private String teamSlug;

private String name;

private String flag;

private String notes;

private String teamFoundation;

private String teamWebsite;

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

}