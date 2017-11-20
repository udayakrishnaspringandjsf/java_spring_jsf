package com.football.eureka;

import java.util.ArrayList;
import java.util.List;

import com.football.eureka.util.JavaToJsonConverterUtil;
import com.google.gson.Gson;

public class JavaTOJsonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Data data=new Data();
		
		FootballBeanData beanData=new FootballBeanData();
		
		data.setStatusReason("OK");
		data.setErrorCode("NA");
		data.setStatusCode("OK");
		League league=new League("EPL");
		List<League> leagueList=new ArrayList<League>();
		leagueList.add(league);
		data.setLeagues(leagueList);
		beanData.setData(data);
		 Gson gson = new Gson();
		 String jsonObject=gson.toJson(beanData);
		 //System.out.println(gson.toJson(beanData));
		//JavaToJsonConverterUtil.javaToJson(beanData);
	}

}
