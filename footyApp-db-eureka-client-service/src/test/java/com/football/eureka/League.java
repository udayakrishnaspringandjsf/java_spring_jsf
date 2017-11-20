package com.football.eureka;

public class League extends FootballBeanData {

	

	public League() {
	}

	public League(String name) {
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}