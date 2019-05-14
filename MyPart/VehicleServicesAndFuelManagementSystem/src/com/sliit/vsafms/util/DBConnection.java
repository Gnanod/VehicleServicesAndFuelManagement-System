package com.sliit.vsafms.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
private static Connection connection;
	
	private DBConnection() {
		
	}
	public static Connection getConnection()  {
		if(connection==null) {
			
			//Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			
//			try {
//				
//				
//				Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
//				connection= DriverManager.getConnection(properties.getProperty(CommonConstants.URL)
//						,properties.getProperty(CommonConstants.USERNAME),properties.getProperty(CommonConstants.PASSWORD));
//			} catch (SQLException e) {
//				
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//				
//			} catch (ClassNotFoundException e) {
//				
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			Properties dbProperties = new Properties();
			File dbFile = new File(System.getProperty("catalina.base")+"\\wtpwebapps\\VehicleServicesAndFuelManagementSystem\\Settings\\config.properties");
			
			FileReader dbFileReader;
			try {
				
				
				dbFileReader = new FileReader(dbFile);
				dbProperties.load(dbFileReader);
				
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}catch(IOException e) {
				
				e.printStackTrace();
				
			}
			
			
			String url = "jdbc:mysql://"
	                + dbProperties.getProperty("ip") + ":"
	                + dbProperties.getProperty("port") + "/"
	                + dbProperties.getProperty("database");
	        String username = dbProperties.getProperty("user");
	        String password = dbProperties.getProperty("password");
	        
	        try {
	        	System.out.println("URL :"+url);
	        	
				connection = DriverManager.getConnection(url, username, password);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return connection;
	}
}
