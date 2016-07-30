package com.enable.regis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import com.enable.regis.dto.LoginDto;
import com.enable.regis.util.EnableDbUtil;


public class LoginDao {
	PreparedStatement ps = null;
	
	public int signUp(LoginDto ldto) {
		int saved = 0;
		String sql = "insert into login_table (user_name, password) values (?,?)";
		
		try {
			
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, ldto.getTextFieldName());
			ps.setString(2, ldto.getTextFieldPass());
			boolean c=check(ldto.getTextFieldName());
			
				if (c==false){
				JOptionPane.showMessageDialog(null, "Username already exists!", "Bad", JOptionPane.ERROR_MESSAGE);}
				else{
					saved=ps.executeUpdate();
				}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return saved;
	}
	
	public boolean checkLogin(String userName, String password) {
		
		boolean login = false;
		
		String sql = "select * from login_table where user_name=? && password=?";
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, userName);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				login = true;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return login;
	}

	private boolean check(String userName) {
		String sql="select user_name from login_table where user_name=?";
		try {
			PreparedStatement ps1=EnableDbUtil.getConnection().prepareStatement(sql);
			ps1.setString(1, userName);
			ResultSet rs=ps1.executeQuery();
			if(rs.next()==true){
				return false;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return true;
		
		
	}
}
