package com.saimon.sp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;


import com.saimon.sp.model.Teams;
import com.saimon.sp.util.SpringProtoDbUtil;

@Component
public class TeamsDao {
	
	public static SpringProtoDbUtil bs() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");
		return ctx.getBean("springProtoDbUtil", SpringProtoDbUtil.class);
	}
	
	
/*	public Teams getTeam(int teamId) {

		
		String sql="select * from teams where team_id=?";
		Teams team = null;
		try {
			
			PreparedStatement ps1=db.getConnection().prepareStatement(sql);
			ps1.setInt(1, teamId);
			ResultSet rs=ps1.executeQuery();
			if(rs.next()){
				team = new Teams(teamId, rs.getString("team_name"));
			}
			ps1.close();
			rs.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		SpringProtoDbUtil db = bs();
		String sql="select * from teams where team_id=?";
		return db.getJdbcTemplate().queryForObject(sql, new Object[] {teamId}, new TeamMapper());
	
	}
*/
	
	public List<Map<String, Object>> getAllTeams(){
		
		SpringProtoDbUtil db = bs();
		String sql="select * from teams";
		//return (List<Teams>)db.getJdbcTemplate().queryForObject(sql, new TeamMapper());
		return db.getJdbcTemplate().queryForList(sql);
		
	}
	
	public void enterTeam(Teams team) {
		SpringProtoDbUtil db = bs();
		String sql = "insert into teams(team_name) values(?)";
		db.getJdbcTemplate().update(sql, new Object[] {team.getTeamName()});
		
	}
	
	
	
	private static class TeamMapper implements RowMapper<Teams>{

		@Override
		public Teams mapRow(ResultSet rs, int rowNum) throws SQLException {
			Teams team = new Teams();
			team.setTeamId(rs.getInt("team_id"));
			team.setTeamName(rs.getString("team_name"));
			return team;
		}
		
	}
	
	
}


