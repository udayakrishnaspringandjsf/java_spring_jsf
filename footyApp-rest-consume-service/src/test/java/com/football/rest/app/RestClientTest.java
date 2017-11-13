package com.football.rest.app;

import java.util.List;

import org.json.JSONObject;

import com.football.rest.bean.Data;
import com.football.rest.bean.FootballBeanData;
import com.football.rest.bean.League;
import com.football.rest.bean.Team;
import com.football.rest.utility.GsonToJSon;
import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class RestClientTest {

	public static final String restURL="https://sportsop-soccer-sports-open-data-v1.p.mashape.com/v1/leagues";
    public static final String key="X6m3INdK8nmshyMn7xRvagJs2mkqp1KBBbqjsnDDGticBSrMiD";
	 private static void listAllLeagues() {
		
		 try {
			HttpResponse<JsonNode> response = Unirest.get(restURL)
					 .header("X-Mashape-Key", key)
					 .header("Accept", "application/json")
					 .asJson();
			
			JSONObject rootObject = response.getBody().getObject();
			FootballBeanData footballData=new FootballBeanData();
			 footballData=(FootballBeanData) GsonToJSon.convertGsonToJson(rootObject, footballData);
			Data data=footballData.getData();
			List<League> leagueData=data.getLeagues();
			 for(League league:leagueData) {
				 System.out.println("League Name :"+ league.getName());
			 }
			
		} catch (UnirestException  e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
	 
	  private static void findTeamsOfLeague(){
		  try {
			  String teamURL="https://sportsop-soccer-sports-open-data-v1.p.mashape.com/v1/leagues/premier-league/seasons/17-18/teams";
				HttpResponse<JsonNode> response = Unirest.get(teamURL).header("X-Mashape-Key", key)
						.header("Accept", "application/json").asJson();

				JSONObject rootObject = response.getBody().getObject();
				FootballBeanData footballData = new FootballBeanData();
				footballData = (FootballBeanData) GsonToJSon.convertGsonToJson(rootObject, footballData);
				Data data = footballData.getData();
				List<Team> teamDataList = data.getTeams();
				for(Team t:teamDataList) {
					System.out.println(t.getName());
				}
				
			
				
				
			} catch (UnirestException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	  }
	/* private static FootballBeanData gsonToJson(JSONObject rootObject) {
		 Gson gsonObj=new Gson();
		 return gsonObj.fromJson(rootObject.toString(), FootballBeanData.class);
	 }*/
	 public static void main(String[] args) {
		//listAllLeagues();
		findTeamsOfLeague();
	}
	 

}
