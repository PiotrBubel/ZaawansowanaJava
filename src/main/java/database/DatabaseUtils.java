package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import frontend.GameSummary;

public class DatabaseUtils {

	private static Connection conn;
	private static Statement stmt;
	private static List<String> rows;
	private static List<String> columns;

        public static Connection getConn() {
            return conn;
        }

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
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Connection closed");
			} catch (SQLException e) {
				System.err.println(e);
			}
		}
	}

	static public String[] getRows() {
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
		return (String[]) rows.toArray(new String[rows.size()]);
	}

	static public String[] getColumns() {
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
		return (String[]) columns.toArray(new String[columns.size()]);
	}

	static public List<GameSummary> getStatistics(int row, int columns) {
		String query = "select * from results where columns = " + columns + " and rows = " + row;
		try {
			System.out.println(query);
			ResultSet rs = stmt.executeQuery(query);
			List<GameSummary> statistic = new ArrayList<>();
			while (rs.next()) {
				statistic.add(new GameSummary(rs.getString("user"), rs.getString("solution"), rs.getDouble("time"),
						rs.getInt("rows"), rs.getInt("columns"), rs.getInt("amountOfMoves")));
			}
			return statistic;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		}

	}

	static public void saveInDatabase(GameSummary summary) {

		String user = summary.getPlayerName();
		String solution = summary.getSolution();
		int moves = summary.getStepsNumber();
		double time = summary.getTime();
		int rows = summary.getRows();
		int columns = summary.getColumns();

		String query = "insert into results (user, solution, amountOfMoves, time, rows, columns ) values " + " (\""
				+ user + "\", \"" + solution + "\"," + moves + ", " + time + ", " + rows + ", " + columns + " )";
		System.out.println(query);
		try {
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			System.err.println(e);
		}
	}

}
