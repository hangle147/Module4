package com.example.tu_dien_don_gian.dao;

import java.sql.*;

public class DictionaryDAO {
    private final String jdbcURL = "jdbc:mysql://localhost:3306/tu_dien_don_gian";
    private final String jdbcUsername = "root";
    private final String jdbcPassword = "Code@22360679";

    public String findMeaning(String word) {
        String meaning = null;
        String sql = "SELECT vietnamese_meaning FROM dictionary WHERE english_word = ?";
        try (Connection conn = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, word.toLowerCase());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) meaning = rs.getString("vietnamese_meaning");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return meaning;
    }
}
