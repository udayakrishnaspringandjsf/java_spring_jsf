package com.football.eureka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LeagueFromRest")
public class LeagueEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private Integer id;
	
	@Column(name="federation")
	private String federation;
	
	
	@Column(name="identifier")
	private String identifier;
	
	@Column(name="league_slug")
	private String leagueSlug;
	
	@Column(name="nation")
	private String nation;
	
	@Column(name="level")
	private String level;
	
	@Column(name="name")
	private String name;
	
	@Column(name="cup")
	private Boolean cup;

	 public LeagueEntity() {
		// TODO Auto-generated constructor stub
	}
	
	 
	 public LeagueEntity(String federation, String identifier, String leagueSlug, String nation, String level,
			String name, Boolean cup) {
		this.federation = federation;
		this.identifier = identifier;
		this.leagueSlug = leagueSlug;
		this.nation = nation;
		this.level = level;
		this.name = name;
		this.cup = cup;
	}


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


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
