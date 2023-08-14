package in.fssa.mynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import in.fssa.mynotes.exception.PersistenceException; // Corrected typo
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.ConnectionUtil;

public class UserDAO {

    public void create(User newuser) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "INSERT INTO users (name, email, password) VALUES (?, ?, ?)";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newuser.getName());
            ps.setString(2, newuser.getEmail());
            ps.setString(3, newuser.getPassword());

            ps.executeUpdate();

            System.out.println("User created Successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            throw new PersistenceException("Error while creating user", e); // Handle the exception properly
        } finally {
            ConnectionUtil.close(conn, ps);
        }
    }

    public void updateName(int id, String newName) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE users SET name = ? WHERE id = ? AND is_active = 1";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newName);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Name updated successfully");
            }
        } catch (SQLException e) {
            throw new PersistenceException("Error while updating name", e); // Handle the exception properly
        }
    }

    public void updatePassword(int id, String newPassword) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE users SET password = ? WHERE id = ? AND is_active = 1";
            conn = ConnectionUtil.getConnection();
            ps = conn.prepareStatement(query);
            ps.setString(1, newPassword);
            ps.setInt(2, id);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Password updated successfully");
            }
        } catch (SQLException e) {
            throw new PersistenceException("Error while updating password", e); // Handle the exception properly
        } finally {
            ConnectionUtil.close(conn, ps);
        }
    }
}
