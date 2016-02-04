package com.ivanpozharskyi.kickstarter2.connection;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String PASSWORD = "root";
	private static final String USERNAME = "root";
	private static String url = "jdbc:mysql://localhost:3306/kickstarter";
	private static Connection connection;
	public static Connection getConnection() {
		try{
			Class.forName("com.mysql.jdbc.Driver");
			try{
				connection = DriverManager.getConnection(url,USERNAME,PASSWORD);
			}catch(SQLException ex){
				System.out.println("Faild to create DB connection");
			}
		}catch(ClassNotFoundException ex){
			System.out.println("Driver not found");
		}
		return connection;
	}
}
