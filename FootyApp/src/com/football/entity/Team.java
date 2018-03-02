package com.football.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the teams database table.
 * 
 */
@Entity
@Table(name="teams")
@NamedQuery(name="Team.findAll", query="SELECT t FROM Team t")
public class Team implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="team_id")
	private String teamId;

	@Column(name="current_manager")
	private String currentManager;

	@Column(name="team_name")
	private String teamName;

	//bi-directional many-to-one association to LeagueType
	@ManyToOne
	@JoinColumn(name="fk_league_type")
	private LeagueType leagueType;

	public Team() {
	}

	public String getTeamId() {
		return this.teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getCurrentManager() {
		return this.currentManager;
	}

	public void setCurrentManager(String currentManager) {
		this.currentManager = currentManager;
	}

	public String getTeamName() {
		return this.teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public LeagueType getLeagueType() {
		return this.leagueType;
	}

	public void setLeagueType(LeagueType leagueType) {
		this.leagueType = leagueType;
	}

}