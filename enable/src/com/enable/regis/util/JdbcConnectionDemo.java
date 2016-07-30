package com.enable.regis.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcConnectionDemo {
	public static void main(String[] args) {
		Connection con = null;
		Statement stmt = null;
		
		String sql = "create database demo";
		
		try {
			//1.register the driver
			Class.forName("com.mysql.jdbc.Driver");
			
			//2. obtain the connection using drivermanager class
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306", "root", "root");
			
			//3. obtain the statement using connection
			stmt = con.createStatement();
			
			//4. execute the query
			stmt.executeUpdate(sql);
			
			System.out.println("connected");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}


}
