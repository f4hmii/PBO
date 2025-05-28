package com.mvcdb.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mvcdb.database.DatabaseConnection;

public class UserDAO {

    public boolean insertUser(User user) {
        String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            System.out.println("✅ Koneksi berhasil.");
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());

            int affectedRows = stmt.executeUpdate();
            System.out.println("✅ Baris yang terpengaruh: " + affectedRows);

            return affectedRows > 0;

        } catch (SQLException e) {
            System.out.println("❌ Error saat insert data:");
            System.out.println("Pesan: " + e.getMessage());
            System.out.println("SQLState: " + e.getSQLState());
            System.out.println("ErrorCode: " + e.getErrorCode());
            e.printStackTrace();
            return false;
        }
    }
}
