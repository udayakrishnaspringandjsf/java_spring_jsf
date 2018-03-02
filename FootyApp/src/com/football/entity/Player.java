package com.football.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the player database table.
 * 
 */
@Entity
@NamedQuery(name="Player.findAll", query="SELECT p FROM Player p")
public class Player implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="player_id")
	private int playerId;

	private int age;

	private int assists;

	@Column(name="clean_sheets")
	private int cleanSheets;

	private String country;

	@Column(name="current_team")
	private String currentTeam;

	@Column(name="first_name")
	private String firstName;

	@Column(name="goals_scored")
	private int goalsScored;

	@Column(name="last_name")
	private String lastName;

	@Column(name="middle_name")
	private String middleName;

	@Column(name="player_name")
	private String playerName;

	private String position;

	@Column(name="previous_clubs")
	private String previousClubs;

	public Player() {
	}

	public int getPlayerId() {
		return this.playerId;
	}

	public void setPlayerId(int playerId) {
		this.playerId = playerId;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAssists() {
		return this.assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getCleanSheets() {
		return this.cleanSheets;
	}

	public void setCleanSheets(int cleanSheets) {
		this.cleanSheets = cleanSheets;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCurrentTeam() {
		return this.currentTeam;
	}

	public void setCurrentTeam(String currentTeam) {
		this.currentTeam = currentTeam;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getGoalsScored() {
		return this.goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getPlayerName() {
		return this.playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public String getPosition() {
		return this.position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPreviousClubs() {
		return this.previousClubs;
	}

	public void setPreviousClubs(String previousClubs) {
		this.previousClubs = previousClubs;
	}

}