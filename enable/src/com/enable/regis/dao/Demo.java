package com.enable.regis.dao;

import java.io.File;

public class Demo {
	private static String OS = System.getProperty("os.name").toLowerCase();
	public static void main(String[] args) {
		
		System.out.println(System.getProperty("user.dir"));
//////		System.out.println(System.getProperty("os.name"));
//////		System.out.println(Long.parseLong("9843040665"));
////		
//		RecipientDetailDto rdto = new RecipientDetailDto();
//		rdto.setId("abc");
//		new CreateFile().checkAndCreate(rdto);
		
		


		
		
	
//			
			System.out.println(OS);
//			System.out.println(OS.indexOf("nux"));
		
		
//			

		String a="";
		String b="nn";
		if(a.isEmpty()||b.isEmpty()) {
			System.out.println("one empty");
		}
		System.out.println(b.contains("n"));
		System.out.println(b.equals("nn"));
		System.out.println(b.equals("n"));
		
		File f= new File("");
		System.out.println(f.toString());
	

}
	public static String getOS() {
		return OS;
	}
	public static void setOS(String oS) {
		OS = oS;
	}
}