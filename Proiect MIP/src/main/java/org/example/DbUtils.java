package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtils {
    private static final String DB_URL = "jdbc:sqlite:catalog.db";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}