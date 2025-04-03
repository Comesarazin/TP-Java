package com.example.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    private static final String URL = "jdbc:sqlite:expenses.db";

    public static String getDatabasePath() {
        String os = System.getProperty("os.name").toLowerCase();
        String userHome = System.getProperty("user.home");
        if (os.contains("win")) {
            return userHome + "\\AppData\\Local\\MonApplication\\database.db";
        } else if (os.contains("mac")) {
            return userHome + "/Library/Application Support/MonApplication/database.db";
        } else {
            return userHome + "/.monapplication/database.db";
        }
    }

    public static Connection connect() throws SQLException {
        String url = "jdbc:sqlite:" + getDatabasePath();
        return DriverManager.getConnection(URL);
    }

    public static void initialize() {
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS expenses (" +
                    "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "periode TEXT NOT NULL," +
                    "total REAL NOT NULL," +
                    "logement REAL NOT NULL," +
                    "nouriture REAL NOT NULL," +
                    "sorties REAL NOT NULL," +
                    "voiture REAL NOT NULL," +
                    "voyage REAL NOT NULL," +
                    "impots REAL NOT NULL," +
                    "autres REAL NOT NULL)";
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Failed to initialize database: " + e.getMessage());
            System.exit(1);
        }
    }
}