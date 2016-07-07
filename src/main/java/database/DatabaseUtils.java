package database;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseUtils {

	private static Connection conn;
	private static Statement stmt;
	private static List<String> rows;
	private static List<String> columns;

	static public void connectToDatabase() {
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost/15puzzle", "root", "");
			System.out.println("Connection success");
			stmt = conn.createStatement();
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

	static public void closeConnection() {
<<<<<<< HEAD
		try {
			conn.close();
			System.out.println("Connection closed");
		} catch (SQLException e) {
			System.err.println(e);
=======
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				System.err.println(e);
			}
>>>>>>> f55e58d... Handled null connection
		}
	}

	static public List<String> getRows() {
		String query = "select distinct rows from results";
		try {
			ResultSet rs = stmt.executeQuery(query);
			rows = new ArrayList<String>();
			while (rs.next()) {
				rows.add(rs.getString("rows"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return rows;
	}

	static public List<String> getColumns() {
		String query = "select distinct columns from results";
		try {
			ResultSet rs = stmt.executeQuery(query);
			columns = new ArrayList<String>();
			while (rs.next()) {
				columns.add(rs.getString("columns"));
			}
		} catch (SQLException e) {
			System.err.println(e);
		}
		return columns;
	}
}
