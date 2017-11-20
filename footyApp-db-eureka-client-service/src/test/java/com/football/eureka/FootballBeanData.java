package com.football.eureka;

import java.util.List;

public class FootballBeanData extends Data{


private Data data;

private List<League>  leagueList;

//private List<Team>   teamList;
 

public Object object;


public FootballBeanData(Data data, List<League> leagueList) {
	this.data = data;
	this.leagueList = leagueList;

}


public FootballBeanData() {
}


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

/*public List<Team> getTeamList() {
	return teamList;
}

public void setTeamList(List<Team> teamList) {
	this.teamList = teamList;
}
*/


}