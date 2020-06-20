package com.Banking.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {
	
	Properties pro;
	
	public ReadConfig()//constructor
	{
		File src = new File("./Configuration/Config.Properties");
		
		try
		{
			FileInputStream fis = new FileInputStream(src);
			pro=new Properties();
			pro.load(fis); // loads complete config file
		}catch(Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// using property files extracting values from config.properties
     public String getApplicationURL() {
    	 String url=pro.getProperty("baseURL");
    	 return url;
     }
     public String getUsername() {
    	 String username=pro.getProperty("username");
    	 return username;}
     public String getPassword() {
    	 String password=pro.getProperty("password");
    	 return password;}
     public String getChromepath() {
         String chromepath=pro.getProperty("chromepath");
         return chromepath;}
     public String getIEpath() {
         String iepath=pro.getProperty("iepath");
         return iepath;}



}
