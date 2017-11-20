package com.football.eureka.bean;

import java.util.List;

import javax.persistence.Transient;

public class FootballBeanData extends Data{


private Data data;

private List<League>  leagueList;

private List<Team>   teamList;
 
@Transient
public Object object;

public Data getData() {
return data;
}

public void setData(Data data) {
this.data = data;
}

public List<League> getLeagues() {
	return leagueList;
}

public void setLeagues(List<League> leagues) {
	this.leagueList = leagues;
}

public List<Team> getTeamList() {
	return teamList;
}

public void setTeamList(List<Team> teamList) {
	this.teamList = teamList;
}



}