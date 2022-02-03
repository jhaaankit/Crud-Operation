package com.ankit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Update {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/ankit";
		String username = "root";
		String password = "root";

		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {

			String sql = "UPDATE Student SET password=?, fullname=?, email=? WHERE username=?";

			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "123456789");
			statement.setString(2, "Rajat Jha");
			statement.setString(3, "rajat@foundation.org");
			statement.setString(4, "Ankit");

			int rowsUpdated = statement.executeUpdate();
			if (rowsUpdated > 0) {
				System.out.println("An existing user was updated successfully!");
			}


		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
}