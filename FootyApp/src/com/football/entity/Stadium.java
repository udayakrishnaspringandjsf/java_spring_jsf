package com.football.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the stadium database table.
 * 
 */
@Entity
@NamedQuery(name="Stadium.findAll", query="SELECT s FROM Stadium s")
public class Stadium implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="stadium_id")
	private int stadiumId;

	private String address;

	private String city;

	private String country;

	@Column(name="league_id")
	private int leagueId;

	@Column(name="stadium_name")
	private String stadiumName;

	public Stadium() {
	}

	public int getStadiumId() {
		return this.stadiumId;
	}

	public void setStadiumId(int stadiumId) {
		this.stadiumId = stadiumId;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getLeagueId() {
		return this.leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getStadiumName() {
		return this.stadiumName;
	}

	public void setStadiumName(String stadiumName) {
		this.stadiumName = stadiumName;
	}

}