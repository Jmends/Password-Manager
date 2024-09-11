package com.jmends;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseHandler {
    private static final String URL = "jdbc:sqlite:manpass.db";

    public static Connection getConnection() throws SQLException {

        return DriverManager.getConnection(URL);
    }

    public static void initializeDatabase() {

        try (Connection conn = getConnection(); Statement stmt = conn.createStatement()) {
            String createUsersTable = "CREATE TABLE IF NOT EXISTS users(" + "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "username TEXT NOT NULL UNIQUE, " +
                    "password_hash TEXT NOT NULL);";
            stmt.execute(createUsersTable);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }

}
