package servlets;

import java.io.IOException;
import extras.DBConnection;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.User;

/**
 * Servlet implementation class SignUp
 */
@WebServlet("/SignUp")
public class SignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUser_name(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		user.setGender(request.getParameter("gender"));
		user.setAddress(request.getParameter("address"));
		user.setZipcode(request.getParameter("zipcode"));
		PrintWriter out = response.getWriter();
		String query="insert into user(user_name,email,password,gender,address,zipcode) values('"+user.getUser_name()+"','"+user.getEmail()+"','"+user.getPassword()+"','"+user.getGender()+"','"+user.getAddress()+"','"+user.getZipcode()+"')";
		DBConnection dbconnection = new DBConnection();
		try {
			dbconnection.create();
			dbconnection.executeUpdate(query);
			dbconnection.close();
			out.println(""
					+ "<html>"
					+ "<body>"
					+ "<script>"
					+ "alert('You Successfully Sign Up!')"
					+ "</script>"
					+ "</body>"
					+ "</html>");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
		
		
		
		
	}

}
