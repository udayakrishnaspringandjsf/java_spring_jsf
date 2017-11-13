package com.football.rest.bean;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class League {

@SerializedName("federation")
@Expose
private String federation;
@SerializedName("identifier")
@Expose
private String identifier;
@SerializedName("league_slug")
@Expose
private String leagueSlug;
@SerializedName("nation")
@Expose
private String nation;
@SerializedName("level")
@Expose
private String level;
@SerializedName("name")
@Expose
private String name;
@SerializedName("cup")
@Expose
private Boolean cup;



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