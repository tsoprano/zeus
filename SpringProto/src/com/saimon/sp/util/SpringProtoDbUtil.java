package com.saimon.sp.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class SpringProtoDbUtil {
	
	
	private DataSource ds;
	private JdbcTemplate jdbcTemplate;
	

	public Connection getConnection() throws ClassNotFoundException, SQLException {
		return ds.getConnection();
	}

	public DataSource getDs() {
		return ds;
	}

	@Autowired()
	@Qualifier("springRelated")
	public void setDs(DataSource ds) {
		this.jdbcTemplate = new JdbcTemplate(ds);
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

}
