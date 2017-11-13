package com.football.rest.bean;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {


@SerializedName("statusReason")
@Expose
private String statusReason;

@JsonIgnoreProperties(ignoreUnknown=true)
@SerializedName("leagues")
@Expose
private List<League> leagues = null;

@SerializedName("errorCode")
@Expose
private String errorCode;

@SerializedName("statusCode")
@Expose
private String statusCode;

@JsonIgnoreProperties(ignoreUnknown=true)
@SerializedName("teams")
@Expose
private List<Team> teams = null;


public String getStatusReason() {
return statusReason;
}

public void setStatusReason(String statusReason) {
this.statusReason = statusReason;
}

public List<League> getLeagues() {
return leagues;
}

public void setLeagues(List<League> leagues) {
this.leagues = leagues;
}

public String getErrorCode() {
return errorCode;
}

public void setErrorCode(String errorCode) {
this.errorCode = errorCode;
}

public String getStatusCode() {
return statusCode;
}

public void setStatusCode(String statusCode) {
this.statusCode = statusCode;
}

public List<Team> getTeams() {
	return teams;
}

public void setTeams(List<Team> teams) {
	this.teams = teams;
}

}