package extras;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.sun.xml.internal.bind.CycleRecoverable.Context;
import java.io.File;


import entity.Book;

public class DBConnection {
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
	public boolean validate(String email, String password) throws SQLException {
		// TODO Auto-generated method stub
		boolean val = false;
		PreparedStatement ps = con.prepareStatement("select email,password from user where email = ? and password = ?");
		ps.setString(1, email);
		ps.setString(2, password);
		ResultSet rs = ps.executeQuery();
		val = rs.next();
		return val;
	}
	public boolean addBook(Book b) throws SQLException, FileNotFoundException {
		PreparedStatement ps = con.prepareStatement("insert into book values(?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, b.getBook_id());
		ps.setString(2, b.getBook_name());
		ps.setString(3, b.getAuthor());
		ps.setString(4, b.getSell_type());
		ps.setInt(5, b.getPrice());
		ps.setString(6, b.getDescription());
		ps.setString(7, b.getType());
		ps.setString(8, b.getImage());
		ps.setString(9, b.getEmail());
		ps.setInt(10, 10);
		return ps.execute();
		
	}

}
