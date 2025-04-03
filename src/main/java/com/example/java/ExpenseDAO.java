package com.example.java;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO {
    public static void insertExpense(Line line) {
        String sql = "INSERT INTO expenses(periode, total, logement, nouriture, sorties, voiture, voyage, impots, autres) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = Database.connect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, line.getPeriode());
            pstmt.setFloat(2, line.getTotal());
            pstmt.setFloat(3, line.getLogement());
            pstmt.setFloat(4, line.getNouriture());
            pstmt.setFloat(5, line.getSorties());
            pstmt.setFloat(6, line.getVoiture());
            pstmt.setFloat(7, line.getVoyage());
            pstmt.setFloat(8, line.getImpots());
            pstmt.setFloat(9, line.getAutres());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Failed to insert expense: " + e.getMessage());
        }
    }

    public static List<Line> getAllExpenses() {
        List<Line> expenses = new ArrayList<>();
        String sql = "SELECT * FROM expenses";

        try (Connection conn = Database.connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Line line = new Line();
                line.setPeriode(rs.getString("periode"));
                line.setTotal(rs.getFloat("total"));
                line.setLogement(rs.getFloat("logement"));
                line.setNouriture(rs.getFloat("nouriture"));
                line.setSorties(rs.getFloat("sorties"));
                line.setVoiture(rs.getFloat("voiture"));
                line.setVoyage(rs.getFloat("voyage"));
                line.setImpots(rs.getFloat("impots"));
                line.setAutres(rs.getFloat("autres"));
                expenses.add(line);
            }
        } catch (SQLException e) {
            System.err.println("Failed to retrieve expenses: " + e.getMessage());
        }
        return expenses;
    }
}