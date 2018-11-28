package com.saimon.sp.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.saimon.sp.dao.TeamsDao;
import com.saimon.sp.model.Teams;

public class TeamsDaoImpl {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		TeamsDao tDao = ctx.getBean("teamsDao", TeamsDao.class);
		//Teams team = tDao.getTeam(1);
	//	System.out.println(team.getTeamName());
	//	tDao.enterTeam(new Teams("ac milan"));
		System.out.println(tDao.getAllTeams());
		
	}
}
