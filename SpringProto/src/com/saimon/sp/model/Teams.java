package com.saimon.sp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="team_details")
public class Teams {
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private int teamId;
	@Column(name="team_name")
	private String teamName;
	
	
	public int getTeamId() {
		return teamId;
	}
	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public Teams(int teamId, String teamName) {
		setTeamId(teamId);
		setTeamName(teamName);
	}
	
	public Teams(String teamName) {
		setTeamName(teamName);
	}
	
	public Teams() {
		// TODO Auto-generated constructor stub
	}

}
