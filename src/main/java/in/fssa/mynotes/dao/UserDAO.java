package in.fssa.mynotes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.fssa.mynotes.exception.PersistanceException;
import in.fssa.mynotes.model.User;
import in.fssa.mynotes.util.ConnectionUtil;

public class UserDAO {

	public void create(User newUser) throws PersistanceException {

		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "select * from users where is_active = 1 email = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setLong(1, newUser.getMobNumber());
			ps.setString(2, newUser.getEmail());
			rs = ps.executeQuery();

			if (rs.next() == true) {
				throw new PersistanceException("User already exist");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e);
			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps, rs);
		}

		try {
			String query = "insert into users (user_name, phone_number, email, password) values (?,?,?,?)";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, newUser.getName());
			ps.setLong(2, newUser.getMobNumber());
			ps.setString(3, newUser.getEmail());
			ps.setString(4, newUser.getPassword());

			ps.executeUpdate();
			System.out.println("User has been created sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
//			System.out.println(e.getMessage());
			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}

	public void update(int id, User updateUser) throws PersistanceException {

		Connection con = null;
		PreparedStatement ps = null;

		try {
			String query = "Update users set user_name = ?, password = ? where id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);

			ps.setString(1, updateUser.getName());
			ps.setString(2, updateUser.getPassword());
			ps.setInt(3, id);

			ps.executeUpdate();
			System.out.println("User has been updated sucessfully");

		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());
		} finally {
			ConnectionUtil.close(con, ps);
		}
	}
	
	// To check whether id is presents
	public void checkIdExists(int id) throws PersistanceException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			String query = "select * from users where is_active = 1 AND id = ?";
			con = ConnectionUtil.getConnection();
			ps = con.prepareStatement(query);
			ps.setInt(1, id);
			rs = ps.executeQuery();

			if (rs.next() == false) {
				throw new PersistanceException("User not found");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new PersistanceException(e.getMessage());
		}  finally {
			ConnectionUtil.close(con, ps, rs);
		}
	}