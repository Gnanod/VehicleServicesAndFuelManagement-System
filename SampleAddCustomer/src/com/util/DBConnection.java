package com.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection extends CommonUtil{
private static Connection connection;
	
	private DBConnection() {
		
	}
	public static Connection getConnection()  {
		if(connection==null) {
			
			//Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			
			try {
				Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
				connection= DriverManager.getConnection(properties.getProperty(CommonConstants.URL)
						,properties.getProperty(CommonConstants.USERNAME),properties.getProperty(CommonConstants.PASSWORD));
			} catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
				
			} catch (ClassNotFoundException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		}
		return connection;
	}
}
