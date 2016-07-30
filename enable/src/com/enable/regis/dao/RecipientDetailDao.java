package com.enable.regis.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.enable.regis.dto.RecipientDetailDto;
import com.enable.regis.util.EnableDbUtil;


public class RecipientDetailDao {
	
	PreparedStatement ps = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;

	public int saveRecipientInfo(RecipientDetailDto rdto) {
		String sql = "insert into personal(name, age, gender, city, area, father, mother, guardian, photo, signature, recipient_id, contact, prosthetic, recieved_date, due_date, remarks, delivery_status, return_status) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		String sql1 = "insert into fullArmDetail(recipient_id, affected_side, unaffected_side, bicep_circum, etw_length, wtf_length) values (?,?,?,?,?,?)";
		String sql2 = "insert into palmOnlyDetail(recipient_id, affected_side, sub_url, aa_url, aa1_url, aa2_url) values (?,?,?,?,?,?)";
		
		int saved = 0;
		int saved1 = 0;
		int saved2 = 0;
		int saved3 = 0;
		
		try {
			
			
			
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, rdto.getName());
			ps.setInt(2, rdto.getAge());
			ps.setString(3, rdto.getGender());
			ps.setString(4, rdto.getCity());
			ps.setString(5, rdto.getArea());
			ps.setString(6, rdto.getFather());
			ps.setString(7, rdto.getMother());
			ps.setString(8, rdto.getGuardian());
			ps.setString(9, rdto.getPicUrl());
			ps.setString(10, rdto.getSignatureUrl());
			ps.setString(11, rdto.getId());
			ps.setLong(12, rdto.getContact());
			ps.setString(13, rdto.getModelType());
			ps.setDate(14, new java.sql.Date( rdto.getRecDate().getTime()));
			ps.setDate(15, new java.sql.Date(rdto.getDueDate().getTime()));
			ps.setString(16, rdto.getRemarks());
			ps.setString(17, rdto.getDeliveryStatus());
			ps.setString(18, rdto.getReturnStatus());
			
			String g = rdto.getModelType();
			
			if(g.contains("Arm+Palm")) {
				
				ps1 = EnableDbUtil.getConnection().prepareStatement(sql1);
				ps1.setString(1, rdto.getId());
				ps1.setString(2, rdto.getAffectedSideArm());
				ps1.setString(3, rdto.getUnaffectedSideArm());
				ps1.setInt(4, rdto.getBicepField());
				ps1.setInt(5, rdto.getEtwField());
				ps1.setInt(6, rdto.getWtfField());
				saved1 = ps1.executeUpdate();
				//System.out.println("here");
				
			}
			
			else if (g.contains("Palm only")) {
				ps2 = EnableDbUtil.getConnection().prepareStatement(sql2);
				ps2.setString(1, rdto.getId());
				ps2.setString(2, rdto.getAffectedSidePalm());
				ps2.setString(3, rdto.getSubUrl());
				ps2.setString(4, rdto.getAaUrl());
				ps2.setString(5, rdto.getAa_1Url());
				ps2.setString(6, rdto.getAa_2Url());
				saved2 = ps2.executeUpdate();
				
			}
			
			else if (g.contains("Other")){
			
				saved3 = 1;
				//lekhna baki chha hai!!!
				
			}
						
			
			saved = ps.executeUpdate();
			saved = saved+saved1+saved2+saved3;
			//System.out.println(saved);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return saved;
	

	}
	
	
	public int updateRecipientInfo(RecipientDetailDto rdto) {
		
		int updated = 0;
		int updated1 = 0;
		int updated2 = 0;
		int updated3 = 0;
		String sql = "update personal set name=?, age=?, gender=?, city=?, area=?, father=?, mother=?, guardian=?, photo=?, signature=?, contact=?, prosthetic=?, recieved_date=?, due_date=?, remarks=?, delivery_status=?, return_status=? where recipient_id=?";
		String sql1 = "update fullArmDetail set affected_side=?, unaffected_side=?, bicep_circum=?, etw_length=?, wtf_length=? where recipient_id=?";
		String sql2 = "update palmOnlyDetail set affected_side=?, sub_url=?, aa_url=?, aa1_url=?, aa2_url=? where recipient_id=?";
		
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			
			ps.setString(1, rdto.getName());
			ps.setInt(2, rdto.getAge());
			ps.setString(3, rdto.getGender());
			ps.setString(4, rdto.getCity());
			ps.setString(5, rdto.getArea());
			ps.setString(6, rdto.getFather());
			ps.setString(7, rdto.getMother());
			ps.setString(8, rdto.getGuardian());
			ps.setString(9, rdto.getPicUrl());
			ps.setString(10, rdto.getSignatureUrl());
			ps.setLong(11, rdto.getContact());
			ps.setString(12, rdto.getModelType());
			ps.setDate(13, new java.sql.Date( rdto.getRecDate().getTime()));
			ps.setDate(14, new java.sql.Date(rdto.getDueDate().getTime()));
			ps.setString(15, rdto.getRemarks());
			ps.setString(16, rdto.getDeliveryStatus());
			ps.setString(17, rdto.getReturnStatus());
			
			ps.setString(18, rdto.getId());
			
			String g = rdto.getModelType();
			
			if(g.contains("Arm+Palm")) {
				
				ps1 = EnableDbUtil.getConnection().prepareStatement(sql1);
				ps1.setString(1, rdto.getAffectedSideArm());
				ps1.setString(2, rdto.getUnaffectedSideArm());
				ps1.setInt(3, rdto.getBicepField());
				ps1.setInt(4, rdto.getEtwField());
				ps1.setInt(5, rdto.getWtfField());
				ps1.setString(6, rdto.getId());
				updated1 = ps1.executeUpdate();
				
				
			}
			
			else if (g.contains("Palm only")) {
				ps2 = EnableDbUtil.getConnection().prepareStatement(sql2);
				ps2.setString(1, rdto.getAffectedSidePalm());
				ps2.setString(2, rdto.getSubUrl());
				ps2.setString(3, rdto.getAaUrl());
				ps2.setString(4, rdto.getAa_1Url());
				ps2.setString(5, rdto.getAa_2Url());
				ps2.setString(6, rdto.getId());
				updated2 = ps2.executeUpdate();
				
			}
			
			else if (g.contains("Other")){
				//System.out.println("here else");
				updated3 = 1;
				//lekhna baki chha hai!!!
				
			}
	
			
			updated = ps.executeUpdate();
			updated = updated+updated1+updated2+updated3;
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return updated;
	}
	
	
	public List<RecipientDetailDto> getAllRecipientList(){
		
		
		List<RecipientDetailDto> recList = new ArrayList<>();
		String sql = "select name, age, city, contact, recipient_id, prosthetic, recieved_date, due_date, delivery_status, return_status from personal";
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecipientDetailDto rdto = new RecipientDetailDto();
				rdto.setName(rs.getString("name"));
				rdto.setCity(rs.getString("city"));
				rdto.setAge(rs.getInt("age"));
				rdto.setContact(rs.getLong("contact"));
				rdto.setId(rs.getString("recipient_id"));
				rdto.setModelType(rs.getString("prosthetic"));
				rdto.setRecDate(rs.getDate("recieved_date"));
				rdto.setDueDate(rs.getDate("due_date"));
				rdto.setDeliveryStatus(rs.getString("delivery_status"));
				rdto.setReturnStatus(rs.getString("return_status"));
				recList.add(rdto);
						
			}
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recList;
		
	}
	
	public List<RecipientDetailDto> searchRecipientList(String recName){
			
			
			List<RecipientDetailDto> recList = new ArrayList<>();
			String sql = "select name, age, city, contact, recipient_id, prosthetic, recieved_date, due_date, delivery_status, return_status from personal where name like ?";
			try {
				ps = EnableDbUtil.getConnection().prepareStatement(sql);
				ps.setString(1, "%"+recName+"%");
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					RecipientDetailDto rdto = new RecipientDetailDto();
					rdto.setName(rs.getString("name"));
					rdto.setCity(rs.getString("city"));
					rdto.setAge(rs.getInt("age"));
					rdto.setContact(rs.getLong("contact"));
					rdto.setId(rs.getString("recipient_id"));
					rdto.setModelType(rs.getString("prosthetic"));
					rdto.setRecDate(rs.getDate("recieved_date"));
					rdto.setDueDate(rs.getDate("due_date"));
					rdto.setDeliveryStatus(rs.getString("delivery_status"));
					rdto.setReturnStatus(rs.getString("return_status"));
					recList.add(rdto);
							
				}
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return recList;
			
		}
	
	
	public void deleteRecipientInfo(String id, String modelType) {
		
		String sql = "delete from personal where recipient_id=?";
		String sql1 = "delete from fullArmDetail where recipient_id=?";
		String sql2 = "delete from palmOnlyDetail where recipient_id=?";
		
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
			
			if(modelType.contains("Arm+Palm")) {
				ps1 = EnableDbUtil.getConnection().prepareStatement(sql1);
				ps1.setString(1, id);
				ps1.executeUpdate();
				
			}
			else if(modelType.contains("Palm only")) {
				ps2 = EnableDbUtil.getConnection().prepareStatement(sql2);
				ps2.setString(1, id);
				ps2.executeUpdate();
				
			}
			else {
				//lekhna baki chha hai!!!
				
			}
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}


	public List<RecipientDetailDto> editRecipientInfo(String id, String modelType) {
		
		
		List<RecipientDetailDto> recList = new ArrayList<>();
		String sql = "select * from personal where recipient_id=?";
		String sql1 = "select affected_side, unaffected_side, bicep_circum, etw_length, wtf_length from fullArmDetail where recipient_id=?";
		String sql2 = "select affected_side, sub_url, aa_url, aa1_url, aa2_url from palmOnlyDetail where recipient_id=?";
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				RecipientDetailDto rdto = new RecipientDetailDto();
				rdto.setName(rs.getString("name"));
				rdto.setAge(rs.getInt("age"));
				rdto.setGender(rs.getString("gender"));
				rdto.setCity(rs.getString("city"));
				rdto.setArea(rs.getString("area"));
				rdto.setFather(rs.getString("father"));
				rdto.setMother(rs.getString("mother"));
				rdto.setGuardian(rs.getString("guardian"));
				rdto.setPicUrl(rs.getString("photo"));
				rdto.setSignatureUrl(rs.getString("signature"));
				rdto.setContact(rs.getLong("contact"));
				rdto.setId(rs.getString("recipient_id"));
				rdto.setDeliveryStatus(rs.getString("delivery_status"));
				rdto.setReturnStatus(rs.getString("return_status"));
				rdto.setModelType(rs.getString("prosthetic"));
				
				if(rs.getString("prosthetic").contains("Arm+Palm")) {
					ps1 = EnableDbUtil.getConnection().prepareStatement(sql1);
					ps1.setString(1, id);
					ResultSet rs1 = ps1.executeQuery();
					while(rs1.next()) {
						rdto.setAffectedSideArm(rs1.getString("affected_side"));
						rdto.setUnaffectedSideArm(rs1.getString("unaffected_side"));
						rdto.setBicepField(rs1.getInt("bicep_circum"));
						rdto.setEtwField(rs1.getInt("etw_length"));
						rdto.setWtfField(rs1.getInt("wtf_length"));
					}
					
				}
				
				else if (rs.getString("prosthetic").contains("Palm only")) {
					ps2 = EnableDbUtil.getConnection().prepareStatement(sql2);
					ps2.setString(1, id);
					ResultSet rs2 = ps2.executeQuery();
					while(rs2.next()) {
						rdto.setAffectedSidePalm(rs2.getString("affected_side"));
						rdto.setSubUrl(rs2.getString("sub_url"));
						rdto.setAaUrl(rs2.getString("aa_url"));
						rdto.setAa_1Url(rs2.getString("aa1_url"));
						rdto.setAa_2Url(rs2.getString("aa2_url"));
						
					}
					
					
				}
				
				else {
					//lekhna baki chha hai....
					
				}
				
				
				rdto.setRecDate(rs.getDate("recieved_date"));
				rdto.setDueDate(rs.getDate("due_date"));
				rdto.setRemarks(rs.getString("remarks"));
				recList.add(rdto);
			}
	
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return recList;
		
		
	}


	public boolean checkId(RecipientDetailDto rdto, int u) {
		boolean check = true;
		if (u==1) {
			String sql = "select * from personal where recipient_id=?";
			try {
				ps = EnableDbUtil.getConnection().prepareStatement(sql);
				ps.setString(1, rdto.getId());
				ResultSet rs = ps.executeQuery();
				if(rs.next()) {
					check = false;
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		else if(u==0) { check= true;}
		
		return check;
	}
	
	public int uploadExtraPhoto(RecipientDetailDto rdto, boolean c) {
		int done = 0;
		if (c==false) {
			String sql = "insert into extra_photos (recipient_id, img1_url, img2_url, img3_url, img4_url, img5_url) values (?,?,?,?,?,?)";
			
			try {
				
				ps = EnableDbUtil.getConnection().prepareStatement(sql);
				ps.setString(1, rdto.getId());
				ps.setString(2, rdto.getImg1Url());
				ps.setString(3, rdto.getImg2Url());
				ps.setString(4, rdto.getImg3Url());
				ps.setString(5, rdto.getImg4Url());
				ps.setString(6, rdto.getImg5Url());
				done = ps.executeUpdate();
				
				
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else {
			String sql = "update extra_photos set img1_url=?, img2_url=?, img3_url=?, img4_url=?, img5_url=? where recipient_id=?";
			try {
				ps = EnableDbUtil.getConnection().prepareStatement(sql);
				ps.setString(1, rdto.getImg1Url());
				ps.setString(2, rdto.getImg2Url());
				ps.setString(3, rdto.getImg3Url());
				ps.setString(4, rdto.getImg4Url());
				ps.setString(5, rdto.getImg5Url());
				ps.setString(6, rdto.getId());
				done = ps.executeUpdate();
				
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		
		}
		
		
		return done;
		
		
	}
	
	
	public List<RecipientDetailDto> extraPhotoInfo(String id) {
		List<RecipientDetailDto> recList = new ArrayList<>();
		String sql = "select * from extra_photos where recipient_id=?";
		try {
			ps = EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
				RecipientDetailDto rdto = new RecipientDetailDto();
				rdto.setImg1Url(rs.getString("img1_url"));
				rdto.setImg2Url(rs.getString("img2_url"));
				rdto.setImg3Url(rs.getString("img3_url"));
				rdto.setImg4Url(rs.getString("img4_url"));
				rdto.setImg5Url(rs.getString("img5_url"));
				recList.add(rdto);
				
			}
			
			
			
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return recList;

		
	}
	
	public boolean checkExtra(String id) {
		boolean check=false;
		String sql = "select * from extra_photos where recipient_id=?";
		try {
			ps=EnableDbUtil.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				check = true;
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return check;
		
	}

	
	

	
	
}
