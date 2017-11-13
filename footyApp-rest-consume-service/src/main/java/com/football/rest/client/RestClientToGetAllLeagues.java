package com.football.rest.client;

import java.util.List;
import java.util.stream.Collectors;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.football.rest.bean.Data;
import com.football.rest.bean.FootballBeanData;
import com.football.rest.bean.League;
import com.football.rest.bean.Team;
import com.football.rest.entity.LeagueEntity;
import com.football.rest.entity.TeamEntity;
import com.football.rest.service.LeagueRepository;
import com.football.rest.service.TeamRepository;
import com.football.rest.utility.GsonToJSon;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;


@RestController
@RequestMapping("/rest/football")
public class RestClientToGetAllLeagues {

	@Autowired 
	private LeagueRepository leagueRepository;
	@Autowired 
	private TeamRepository teamRepository;
	
	public static final String restURLForLeague = "https://sportsop-soccer-sports-open-data-v1.p.mashape.com/v1/leagues";
	public static final String restURLForTeam = "https://sportsop-soccer-sports-open-data-v1.p.mashape.com/v1/leagues/";
	public static final String key = "";//Get your own Key!!
	
	LeagueEntity leagueToPersist = null;
	TeamEntity teamEntityToPersist=null;
	
	@GetMapping("/listleagues")
	public List<String> listAndSaveAllLeagues() {
		
		try {
			HttpResponse<JsonNode> response = Unirest.get(restURLForLeague).header("X-Mashape-Key", key)
					.header("Accept", "application/json").asJson();

			JSONObject rootObject = response.getBody().getObject();
			FootballBeanData footballData = new FootballBeanData();
			footballData = (FootballBeanData) GsonToJSon.convertGsonToJson(rootObject, footballData);
			Data data = footballData.getData();
			List<League> leagueDataList = data.getLeagues();
			
			
			leagueDataList.stream().map((league) -> {
			
				leagueToPersist=new LeagueEntity(league.getFederation(),league.getIdentifier(),league.getLeagueSlug(),league.getNation(),league.getLevel(),league.getName(),league.getCup());
				return league;
			}).forEachOrdered((league) -> {
				leagueRepository.save(leagueToPersist);
	        });
			
			
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getAllLeagueNames();
	}
	
	@GetMapping("/listTeams/{league_slug}/seasons/17-18/teams")
	public List<String> listAndSaveTeamToLeague(@PathVariable("league_slug")final String league_slug){
		try {
			HttpResponse<JsonNode> response = Unirest.get(restURLForTeam+league_slug+"/seasons/17-18/teams").header("X-Mashape-Key", key)
					.header("Accept", "application/json").asJson();

			JSONObject rootObject = response.getBody().getObject();
			FootballBeanData footballData = new FootballBeanData();
			footballData = (FootballBeanData) GsonToJSon.convertGsonToJson(rootObject, footballData);
			Data data = footballData.getData();
			List<Team> teamDataList = data.getTeams();
			
			teamDataList.stream().
			map((team) -> {
				teamEntityToPersist=new TeamEntity(team.getIdentifier(), team.getTeamSlug(),
						     team.getName(), team.getFlag(), team.getNotes(), team.getTeamFoundation(), team.getTeamWebsite(),league_slug);
				   return team;
			}) .forEach((team) ->{
				teamRepository.save(teamEntityToPersist);
			});
			
			
		} catch (UnirestException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return getTeamsByTeamSlug(league_slug);
		
	}
	private List<String> getAllLeagueNames() {
		return leagueRepository.findAll().stream().map(LeagueEntity::getName).collect(Collectors.toList());
	}
	private List<String> getTeamsByTeamSlug(String teamSlug){
		return teamRepository.findTeamBySlug(teamSlug);
	}

}
