package com.enable.regis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class EnableDbUtil {
	
	private final static String DRIVER_NAME = "com.mysql.jdbc.Driver";
	private final static String DATABASE_NAME = "enabledb";
	private final static String URL = "jdbc:mysql://localhost:3306/";
	private final static String USERNAME = "root";
	private final static String PASSWORD = "root";

	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		return DriverManager.getConnection(URL + DATABASE_NAME, USERNAME, PASSWORD);
	}
	

}
