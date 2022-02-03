package com.ankit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insert {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/ankit";
		String username = "root";
		String password = "root";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "INSERT INTO Student (username, password, fullname, email) VALUES (?, ?, ?, ?)";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "Ankit");
			statement.setString(2, "1235");
			statement.setString(3, "Ankit Jha");
			statement.setString(4, "anit.jha@microsoft.com");
			
			int rowsInserted = statement.executeUpdate();
			if (rowsInserted > 0) {
				System.out.println("A new user was inserted successfully!");
			}

			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}