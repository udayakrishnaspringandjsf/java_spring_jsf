package com.football.eureka.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team_from_rest")
public class TeamEntity {

 @Column
 @Id
@GeneratedValue(strategy=GenerationType.AUTO)
 private Integer Id; 
	
	@Column
	private String identifier;
	
	@Column
	private String teamSlug;
	
	@Column
	private String name;
	
	@Column
	private String flag;
	
	@Column
	private String notes;
	
	@Column
	private String teamFoundation;
	
	@Column
	private String teamWebsite;
	
	@Column
	private String leagueSlug;

	public TeamEntity() {
	}

	public TeamEntity(String identifier, String teamSlug, String name, String flag, String notes, String teamFoundation,
			String teamWebsite,String leagueSlug) {
		this.identifier = identifier;
		this.teamSlug = teamSlug;
		this.name = name;
		this.flag = flag;
		this.notes = notes;
		this.teamFoundation = teamFoundation;
		this.teamWebsite = teamWebsite;
		this.leagueSlug=leagueSlug;
	}

	public String getIdentifier() {
		return identifier;
		}

		public void setIdentifier(String identifier) {
		this.identifier = identifier;
		}

		public String getTeamSlug() {
		return teamSlug;
		}

		public void setTeamSlug(String teamSlug) {
		this.teamSlug = teamSlug;
		}

		public String getName() {
		return name;
		}

		public void setName(String name) {
		this.name = name;
		}

		public String getFlag() {
		return flag;
		}

		public void setFlag(String flag) {
		this.flag = flag;
		}

		public String getNotes() {
		return notes;
		}

		public void setNotes(String notes) {
		this.notes = notes;
		}

		public String getTeamFoundation() {
		return teamFoundation;
		}

		public void setTeamFoundation(String teamFoundation) {
		this.teamFoundation = teamFoundation;
		}

		public String getTeamWebsite() {
		return teamWebsite;
		}

		public void setTeamWebsite(String teamWebsite) {
		this.teamWebsite = teamWebsite;
		}

		public String getLeagueSlug() {
			return leagueSlug;
		}

		public void setLeagueSlug(String leagueSlug) {
			this.leagueSlug = leagueSlug;
		}

	
}
