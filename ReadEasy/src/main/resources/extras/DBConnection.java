package servlets;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

class DBConnection {
	Connection con;
	Statement stmt;
	
	public void create() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fyp", "admin", "admin");
			    stmt = con.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}
	public int executeUpdate(String query) throws SQLException {
		return stmt.executeUpdate(query);
	}
	public void close() throws SQLException {
		con.close();
	}
	public ResultSet executeQuery(String query) throws SQLException {
		return stmt.executeQuery(query);
	}

}
