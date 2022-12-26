package com.cuongnguyen.config;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.log4j.Logger;

public class ConnectDB {
	private static final Logger logger = Logger.getLogger(ConnectDB.class);
	private static String DB_URL = "jdbc:mysql://localhost:3306/emp-manager";
    private static String USER_NAME = "root";
    private static String PASSWORD = "";
    public static Connection getConnection() {
    	Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USER_NAME, PASSWORD);
            logger.info("connect successfully");
        } catch (Exception ex) {
        	logger.error("error in here", ex);
        	ex.printStackTrace();
        }
        return conn;
    }
    
	public static Connection getConnection(String dbURL, String userName, 
            String password) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, userName, password);
            System.out.println("Connect success");
        } catch (Exception ex) {
        	logger.error("error in here", ex);
        	ex.printStackTrace();
        }
        return conn;
    }
}
