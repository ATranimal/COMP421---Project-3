
/**
 * Make sure the Postgresql JDBC driver is in your classpath.
 * You can download the JDBC 4 driver from here if required.
 * https://jdbc.postgresql.org/download.html
 *
 * take care of the variables usernamestring and passwordstring to use 
 * appropriate database credentials before you compile !
 *
**/

import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

import java.util.Scanner;

class BeerCompany {
	public static void main(String[] args) throws SQLException {
		// Unique table names. Either the user supplies a unique identifier as a command
		// line argument, or the program makes one up.
		String tableName = "";
		int sqlCode = 0; // Variable to hold SQLCODE
		String sqlState = "00000"; // Variable to hold SQLSTATE

		if (args.length > 0) {
			tableName += args[0];
		} else {
			tableName += "example3.tbl";
		}

		// Register the driver. You must register the driver before you can use it.
		try {
			DriverManager.registerDriver(new org.postgresql.Driver());
		} catch (Exception cnfe) {
			System.out.println("Class not found");
		}

		// This is the url you must use for Postgresql.
		// Note: This url may not valid now !
		String url = "jdbc:postgresql://comp421.cs.mcgill.ca:5432/cs421";
		String usernamestring = "cs421g22";
		String passwordstring = "!brewbeer22";
		Connection con = DriverManager.getConnection(url, usernamestring, passwordstring);
		Statement statement = con.createStatement();

		askForInput(statement);
		
		// Finally but importantly close the statement and connection
		statement.close();
		con.close();
	}

	public static void askForInput(Statement statement) {
		Scanner scan = new Scanner(System.in); // Reading from System.in
		System.out.println("Please enter the number for the option you want:");
		System.out.println("1) Get all beers in the database");
		System.out.println("2) SQL 2");
		System.out.println("3) SQL 3");
		System.out.println("4) SQL 4");
		System.out.println("5) SQL 5");
		System.out.println("6) Exit");

		int i = scan.nextInt();

		if (i == 1)
			sql1(statement);
		else if (i == 2)
			sql2(statement);
		else if (i == 3)
			sql3(statement);
		else if (i == 4)
			sql4(statement);
		else if (i == 5)
			sql5(statement);
		else if (i == 6)
			System.out.println("Exitng and closing conections.");
	}

	public static void sql1(Statement statement) {
		try {
			String querySQL = "SELECT DISTINCT beerName FROM beer";
			java.sql.ResultSet rs = statement.executeQuery(querySQL);
			while (rs.next()) {
				String name = rs.getString(1);
				System.out.println("name:  " + name);
			}
		} catch (SQLException e) {
			int sqlCode = e.getErrorCode(); // Get SQLCODE
			String sqlState = e.getSQLState(); // Get SQLSTATE

			// Your code to handle errors comes here;
			// something more meaningful than a print would be good
			System.out.println("Code: " + sqlCode + "  sqlState: " + sqlState);
		}
		
		System.out.println("Closing Connection.");
	}

	public static void sql2(Statement statement) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter input:");
		
		int i = scan.nextInt();
	}

	public static void sql3(Statement statement) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter input:");

		int i = scan.nextInt();
	}

	public static  void sql4(Statement statement) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter input:");

		int i = scan.nextInt();
	}

	public static void sql5(Statement statement) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter input:");

		int i = scan.nextInt();
	}
}