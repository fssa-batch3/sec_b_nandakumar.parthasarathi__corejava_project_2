package in.fssa.mynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.fssa.mynotes.Interface.UserInterface;
import in.fssa.mynotes.exception.PersistanceException; // Correct the typo here
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.ConnectionUtil;

public class UserDAO implements UserInterface {

    public void create(User newUser) throws PersistanceException { // Correct the typo here

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT name, email, password FROM users WHERE is_active = 1 AND email = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, newUser.getEmail());
            rs = ps.executeQuery();

            if (rs.next()) { // Simplified condition, no need for `== true`
                throw new PersistanceException("User already exists"); // Correct the typo here
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getMessage()); // Correct the typo here
        } finally {
            ConnectionUtil.close(con, ps, rs);
        } 

        try {
            String query = "INSERT INTO users (name, email, password) VALUES (?,?,?)";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, newUser.getName());
            ps.setString(2, newUser.getEmail());
            ps.setString(3, newUser.getPassword());

            ps.executeUpdate();
            System.out.println("User has been created successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getMessage()); // Correct the typo here
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }

    public void update(int id, User updateUser) throws PersistanceException { // Correct the typo here

        Connection con = null;
        PreparedStatement ps = null;

        try {
            String query = "UPDATE users SET name = ?, password = ? WHERE id = ? AND is_active = 1";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, updateUser.getName());
            ps.setString(2, updateUser.getPassword());
            ps.setInt(3, id);

            ps.executeUpdate();
            System.out.println("User has been updated successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getMessage()); // Correct the typo here
        } finally {
            ConnectionUtil.close(con, ps);
        }
    }


    // To check whether id is present
    public void checkIdExists(int id) throws PersistanceException { // Correct the typo here
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT name FROM users WHERE is_active = 1 AND id = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (!rs.next()) { // Simplified condition
                throw new PersistanceException("User not found"); // Correct the typo here
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getMessage()); // Correct the typo here
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
    }

    public void checkUserCredentials(String email, String password) throws PersistanceException { // Correct the typo here

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            String query = "SELECT password FROM users WHERE email = ?"; // Correct the column name here
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);

            ps.setString(1, email); // Correct the parameter here

            rs = ps.executeQuery();

            if (!rs.next()) {
                throw new PersistanceException("Invalid Login Credentials");
            } else {
                if (!rs.getString("password").equals(password)) {
                    throw new PersistanceException("Invalid Login Credentials");
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            throw new PersistanceException(e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
    }
    
    
    public static User findUserByEmail(String email) throws PersistanceException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        User user = null;

        try {
            String query = "SELECT id, name, email FROM users WHERE email = ?";
            con = ConnectionUtil.getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, email);
            rs = ps.executeQuery();

            if (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setName(rs.getString("name"));
                user.setEmail(rs.getString("email"));
                
            }
        } catch (SQLException e) {
            throw new PersistanceException("Error while fetching user by email: " + e.getMessage());
        } finally {
            ConnectionUtil.close(con, ps, rs);
        }
        return user;
    }


}
