package com.football.eureka.resource;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.eureka.bean.Data;
import com.football.eureka.bean.FootballBeanData;
import com.football.eureka.bean.League;
import com.football.eureka.bean.Team;
import com.football.eureka.entity.LeagueEntity;
import com.football.eureka.entity.TeamEntity;
import com.football.eureka.service.FootballLeagueService;
import com.football.eureka.service.FootballTeamService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

@RestController
@RequestMapping("/football")
public class FootballServiceResource {

	@Autowired
	FootballLeagueService footballLeagueService;

	@Autowired
	FootballTeamService footballTeamService;

	FootballBeanData beanData = new FootballBeanData();
	Data data = new Data();
	List<League> leagueBeanList = new ArrayList<League>();

	League leagueObj = null;
	Team teamObj = null;
	List<LeagueEntity> leagueEntityList = new ArrayList<LeagueEntity>();
	List<TeamEntity> teamEntityList = new ArrayList<TeamEntity>();
	Gson gson = new GsonBuilder().setPrettyPrinting().create();
	String json = "";

	@GetMapping("/getAllLeague")
	public String getLeaguesAsJSON() {
		data.setStatusCode("200");
		data.setStatusReason("OK");

		leagueEntityList = getLeaguesFromService();

		leagueEntityList.stream().map((leagueEntity) -> {

			leagueObj = new League(leagueEntity.getFederation(), leagueEntity.getIdentifier(),
					leagueEntity.getLeagueSlug(), leagueEntity.getNation(), leagueEntity.getLevel(),
					leagueEntity.getName(), leagueEntity.getCup());
			return leagueEntity;
		}).forEachOrdered((leagueEntity) -> {
			leagueBeanList.add(leagueObj);
		});
		data.setLeagues(leagueBeanList);
		beanData.setData(data);
		return gson.toJson(beanData);
		// return json;

	}

	@GetMapping("/getTeamsByLeague/{league_slug}")
	public String getTeamByLeagueAsJSON(@PathVariable("league_slug") final String league_slug,
			@RequestHeader HttpHeaders header) {
		Boolean authenticatedUser = false;
		List<String> key = header.get("key");
		if (key.get(0).equalsIgnoreCase("password")) {
			authenticatedUser = true;
		}
		List<Team> teamBeanList = new ArrayList<Team>();

		if (authenticatedUser) {
			data.setStatusCode("OK");
			data.setStatusReason("OK");

			teamEntityList = getTeamsByLeagueSLug(league_slug);

			teamEntityList.stream().map((teamEntity) -> {

				teamObj = new Team(teamEntity.getIdentifier(), teamEntity.getTeamSlug(), teamEntity.getName(),
						teamEntity.getFlag(), teamEntity.getNotes(), teamEntity.getTeamFoundation(),
						teamEntity.getTeamWebsite(), league_slug);
				return teamEntity;
			}).forEachOrdered((teamEntity) -> {
				teamBeanList.add(teamObj);
			});
			data.setTeams(teamBeanList);
		} else {

			data.setStatusReason("Unauthorized User");
			data.setStatusCode("401");
			data.setTeams(null);
		}

		beanData.setData(data);

		return gson.toJson(beanData);

	}

	private List<LeagueEntity> getLeaguesFromService() {

		return footballLeagueService.findAll();

	}

	private List<TeamEntity> getTeamsByLeagueSLug(String leagueSlug) {
		return footballTeamService.findTeamByLeagueSlug(leagueSlug);
	}

}
