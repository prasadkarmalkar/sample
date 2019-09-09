package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import extras.DBConnection;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SignIn
 */
@WebServlet("/SignIn")
public class SignIn extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignIn() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String email= request.getParameter("email");
		String password= request.getParameter("password");
		DBConnection dbConnection = new DBConnection();
		try {
			dbConnection.create();
			if(dbConnection.validate(email,password)) {
				HttpSession session = request.getSession();
				session.setAttribute("email", email);
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else {
				out.println("<script>"
						+ "alert('Email Or Password Is Wrong');"
						+ "</script>");
				request.getRequestDispatcher("user_login.jsp").include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
	}

}
