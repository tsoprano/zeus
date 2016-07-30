package com.enable.regis.dao;

import java.io.File;

import com.enable.regis.dto.RecipientDetailDto;

public class CreateFile {
	private static String OS = System.getProperty("os.name").toLowerCase();
	
	public String checkAndCreate(RecipientDetailDto rdto, int u) {

		String fileName = rdto.getId();
		String dirname = null;
		String status="error";
	
			if (isWindows()) {
				
				if(u==1) {
					dirname = System.getProperty("user.dir")+ "\\" +fileName;
					status=makeFile(dirname);
					if(status.contains("error")) { return status; }
					else {dirname = System.getProperty("user.dir")+ "\\" +fileName+"\\";}
					return dirname;
					
				}
				
				else {
					dirname = System.getProperty("user.dir")+ "\\" +fileName+"\\";
					return dirname;
				}
				
				
			
				
			} else if (isMac()) {
				
				if(u==1) {
					dirname = System.getProperty("user.dir")+"/"+fileName;
					status=makeFile(dirname);
					if(status.contains("error")) { return status; }
					else {dirname = System.getProperty("user.dir")+ "/" +fileName+"/";}
					return dirname;
					
				}
				else {
					dirname = System.getProperty("user.dir")+ "/" +fileName+"/";
					return dirname;
				}
				
				
			} else if (isUnix()) {
				
				if(u==1) {
					
					dirname = System.getProperty("user.dir")+"/"+fileName;
					status=makeFile(dirname);
					if(status.contains("error")) { return status; }  
					else {dirname = System.getProperty("user.dir")+ "/" +fileName+"/";}
					return dirname;
				}
				else {
					dirname = System.getProperty("user.dir")+ "/" +fileName+"/";
					return dirname;
				}
				
			}
				
				return status;
			
			
			
		

		
	}
	
	public static boolean isWindows() {

		return (OS.indexOf("win") >= 0);

	}

	public static boolean isMac() {

		return (OS.indexOf("mac") >= 0);

	}

	public static boolean isUnix() {

		return (OS.indexOf("nix") >= 0 || OS.indexOf("nux") >= 0 || OS.indexOf("aix") > 0 );
		
	}

	public static boolean isSolaris() {

		return (OS.indexOf("sunos") >= 0);

	}
	
	public String makeFile(String s) {
		File d = new File(s);
		if(d.mkdirs()==false) {return "error";	}
		else { return "good";}
		
	}
	
	



}
