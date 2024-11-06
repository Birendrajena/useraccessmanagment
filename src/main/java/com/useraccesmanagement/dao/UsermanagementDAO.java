package com.useraccesmanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.useraccesmanagement.model.Request;
import com.useraccesmanagement.model.Software;
import com.useraccesmanagement.model.User;

public class UsermanagementDAO {
	public int insertUser(User user) throws SQLException {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO users ( username,password,role) VALUES (?, ?, ?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			ps.setString(3, user.getRole());

			count = ps.executeUpdate();
		} finally {

			DatabaseConnection.closeConnection(connection);
		}

		return count;

	}

	public User getUser(String username, String password) throws SQLException {
		User user = null;
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SElECT id,username,password,role FROM users WHERE username='"
					+ username + "' and password='" + password+"'");
			while (results.next()) {
				user = new User();
				user.setId(results.getInt("id"));
				user.setUsername(results.getString("username"));
				user.setPassword(results.getString("password"));
				user.setRole(results.getString("role"));
			}
		} finally {

			DatabaseConnection.closeConnection(connection);
		}
		return user;
	}

	public int insertSoftware(Software software) throws SQLException {
		int count = 0;
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO software ( name,description,access_levels) VALUES (?, ?, ?)");
			ps.setString(1, software.getName());
			ps.setString(2, software.getDescription());
			ps.setString(3, software.getAccessLevels());

			count = ps.executeUpdate();
		} finally {

			DatabaseConnection.closeConnection(connection);
		}

		return count;

	}

	public List<Software> getSoftwares() throws SQLException {
		List<Software> softwares = new ArrayList<Software>();
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("SElECT id,name,description,access_levels FROM software");
			while (results.next()) {
				Software software = new Software();
				software.setId(results.getInt("id"));
				software.setName(results.getString("name"));
				software.setDescription(results.getString("description"));
				software.setAccessLevels(results.getString("access_levels"));
				softwares.add(software);
			}
		} finally {

			DatabaseConnection.closeConnection(connection);
		}
		return softwares;
	}

	public int insertRequest(Request request) throws SQLException {
		Connection connection = null;
		int count = 0;
		try {
			connection = DatabaseConnection.getConnection();
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO requests ( user_id,software_id,access_type,reason,status) VALUES (?, ?, ?,?,?)");
			ps.setInt(1, request.getUserId());
			ps.setInt(2, request.getSoftwareId());
			ps.setString(3, request.getAccessType());
			ps.setString(4, request.getReason());
			ps.setString(5, request.getStatus());

			count = ps.executeUpdate();
		} finally {

			DatabaseConnection.closeConnection(connection);
		}

		return count;

	}

	public List<Request> getRequests() throws SQLException {
		List<Request> requests = new ArrayList<>();;
		Connection connection = null;
		try {
			connection = DatabaseConnection.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery(
					"SELECT req.id,u.username,sw.name,req.access_type,req.reason,req.status FROM requests req "
							+ " inner join users u on u.id = req.user_id  "
							+ " inner join software sw on sw.id = req.software_id WHERE req.status='Pending'");
			while (results.next()) {
				Request request = new Request();
				request.setId(results.getInt("id"));
				// request.setUserId(results.getInt("user_id"));
				// request.setSoftwareId(results.getInt("software_id"));
				request.setEmployeeName(results.getString("username"));
				request.setSoftwareName(results.getString("name"));
				request.setAccessType(results.getString("access_type"));
				request.setReason(results.getString("reason"));
				request.setStatus(results.getString("status"));
				requests.add(request);
			}
		} finally {

			DatabaseConnection.closeConnection(connection);
		}
		return requests;
	}

	public int updateRequest(String status, Integer id) throws SQLException {
		Connection connection = null;
		int count = 0;

		try {

			connection = DatabaseConnection.getConnection();

			String sql = "UPDATE requests SET status = ? WHERE id = ?";

			PreparedStatement ps = connection.prepareStatement(sql);

			ps.setString(1, status);
			ps.setInt(2, id);

			count = ps.executeUpdate();
		} finally {

			DatabaseConnection.closeConnection(connection);
		}

		return count;
	}

}
