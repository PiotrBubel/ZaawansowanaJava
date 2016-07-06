package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {

	public static void main(String[] args) {
		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quiz", "root", "");
			//System.out.println("Connection success");
			String query = "SELECT * FROM TEST";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()) {
				System.out.println("Name: " + rs.getString("slowo"));
			}
		} catch (Exception e) {
			System.err.println(e);
		}

	}

}
