package com.library.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    static {
        EnvLoader.loader(".env");
    }
    public static Connection getConnection() throws SQLException{
        String url = System.getProperty("DB_URL");
        String user = System.getProperty("DB_USER");
        String password = System.getProperty("DB_PASSWORD");
        return DriverManager.getConnection(url,user,password);
    }
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Connection successful!");
        } catch (SQLException e) {
            System.out.println("❌ Connection failed: " + e.getMessage());
        }
    }

}
