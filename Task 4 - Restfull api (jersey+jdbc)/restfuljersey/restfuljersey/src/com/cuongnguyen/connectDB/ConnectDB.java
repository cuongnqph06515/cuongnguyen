package com.cuongnguyen.connectDB;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.ws.rs.core.Application;

public class ConnectDB extends Application{
	private static String DB_URL = "jdbc:mysql://localhost:3306/emp-manager";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    public static Connection getConnection() {
    	Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
    
	public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("connect successfully!");
        } catch (Exception ex) {
            System.out.println("connect failure!");
            ex.printStackTrace();
        }
        return conn;
    }
}
