package com.useraccesmanagement.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

	static String jdbcURL = "jdbc:postgresql://localhost:5432/Uamsdb";
	static String username = "postgres";
	static String password = "birendra@79";

	static {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(jdbcURL, username, password);

			return connection;
		} catch (SQLException e) {
			System.out.println("error");
			e.printStackTrace();

		}
		return connection;
	}

	public static void closeConnection(Connection connection) {

		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
