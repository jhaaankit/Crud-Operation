package com.ankit.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Delete {

	public static void main(String[] args) {
		String dbURL = "jdbc:mysql://localhost:3306/ankit";
		String username = "root";
		String password = "root";
		
		try (Connection conn = DriverManager.getConnection(dbURL, username, password)) {
			
			String sql = "DELETE FROM Student WHERE username=?";
			
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, "Ankit");
			
			int rowsDeleted = statement.executeUpdate();
			if (rowsDeleted > 0) {
				System.out.println("A user was deleted successfully!");
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}		
	}
}