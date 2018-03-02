package com.football.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the league_type database table.
 * 
 */
@Entity
@Table(name="league_type")
@NamedQueries({
@NamedQuery(name="LeagueType.findAll", query="SELECT l FROM LeagueType l"),
@NamedQuery(name="LeagueType.findLeagueByName",query="SELECT l from LeagueType l where l.leagueName=:leagueName")
})
public class LeagueType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="league_id")
	private int leagueId;

	@Column(name="alias_name")
	private String aliasName;

	@Column(name="league_country")
	private String leagueCountry;

	@Column(name="league_name")
	private String leagueName;

	//bi-directional many-to-one association to Team
	@OneToMany(mappedBy="leagueType")
	private List<Team> teams;

	public LeagueType() {
	}

	public int getLeagueId() {
		return this.leagueId;
	}

	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}

	public String getAliasName() {
		return this.aliasName;
	}

	public void setAliasName(String aliasName) {
		this.aliasName = aliasName;
	}

	public String getLeagueCountry() {
		return this.leagueCountry;
	}

	public void setLeagueCountry(String leagueCountry) {
		this.leagueCountry = leagueCountry;
	}

	public String getLeagueName() {
		return this.leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public List<Team> getTeams() {
		return this.teams;
	}

	public void setTeams(List<Team> teams) {
		this.teams = teams;
	}

	public Team addTeam(Team team) {
		getTeams().add(team);
		team.setLeagueType(this);

		return team;
	}

	public Team removeTeam(Team team) {
		getTeams().remove(team);
		team.setLeagueType(null);

		return team;
	}

}