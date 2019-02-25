package com.myaustralia.common;

import java.sql.*;
import java.util.ResourceBundle;

public class DatabaseHelper {
	
	private static String driverClass;
	private static String url;
	private static String username;
	private static String password;

	static {
		//load database connection data from database.properties file
		ResourceBundle rb = ResourceBundle.getBundle("database");
		driverClass = rb.getString("driverClass");
		url = rb.getString("url");
		username = rb.getString("username");
		password = rb.getString("password");
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws Exception{
		return DriverManager.getConnection(url,username,password);
	}

	public static void closeAll(ResultSet rs , PreparedStatement pre, Connection conn){
		if (rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pre != null){
			try {
				pre.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}