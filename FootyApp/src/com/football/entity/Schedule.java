package com.football.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.Date;


/**
 * The persistent class for the schedule database table.
 * 
 */
@Entity
@NamedQuery(name="Schedule.findAll", query="SELECT s FROM Schedule s")
public class Schedule implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="schedule_id")
	private int scheduleId;

	private String away_Team;

	private String country;

	private String home_Team;

	@Temporal(TemporalType.DATE)
	@Column(name="match_date")
	private Date matchDate;

	@Column(name="match_time")
	private Time matchTime;

	private String stadium;

	//bi-directional many-to-one association to LeagueType
	/*@ManyToOne
	@JoinColumn(name="fk_league_id")
	private LeagueType leagueType1;

	//bi-directional many-to-one association to LeagueType
	@ManyToOne
	@JoinColumn(name="fk_league_id")
	private LeagueType leagueType2;*/

	public Schedule() {
	}

	public int getScheduleId() {
		return this.scheduleId;
	}

	public void setScheduleId(int scheduleId) {
		this.scheduleId = scheduleId;
	}

	public String getAway_Team() {
		return this.away_Team;
	}

	public void setAway_Team(String away_Team) {
		this.away_Team = away_Team;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getHome_Team() {
		return this.home_Team;
	}

	public void setHome_Team(String home_Team) {
		this.home_Team = home_Team;
	}

	public Date getMatchDate() {
		return this.matchDate;
	}

	public void setMatchDate(Date matchDate) {
		this.matchDate = matchDate;
	}

	public Time getMatchTime() {
		return this.matchTime;
	}

	public void setMatchTime(Time matchTime) {
		this.matchTime = matchTime;
	}

	public String getStadium() {
		return this.stadium;
	}

	public void setStadium(String stadium) {
		this.stadium = stadium;
	}

/*	public LeagueType getLeagueType1() {
		return this.leagueType1;
	}

	public void setLeagueType1(LeagueType leagueType1) {
		this.leagueType1 = leagueType1;
	}

	public LeagueType getLeagueType2() {
		return this.leagueType2;
	}

	public void setLeagueType2(LeagueType leagueType2) {
		this.leagueType2 = leagueType2;
	}*/

}