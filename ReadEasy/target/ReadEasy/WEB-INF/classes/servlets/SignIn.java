package servlets;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		String email=request.getParameter("email");
		String password = request.getParameter("password");
		String name = null;
		String id = null;
		String query = "select email,password,user_name,user_id from user";
		boolean pass=false;
		DBConnection con = new DBConnection();
		try {
			con.create();
			ResultSet rs = con.executeQuery(query);
			while(rs.next()) {
				if(email.contentEquals(rs.getString("email"))) {
					if(password.contentEquals(rs.getString("password"))) {
						pass=true;
						name=rs.getString("user_name");
						id=rs.getString("user_id");
						break;
						
					}
				}
			}
			if(pass) {
				name = name.split(" (?!.* )")[0];
				Cookie id_cookie = new Cookie("id",id);
				Cookie name_cookie = new Cookie("name",name);
				response.addCookie(id_cookie);
				response.addCookie(name_cookie);
				response.sendRedirect("index.jsp");
			}else {
				response.sendRedirect("user_login.html");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e);
		}
			try {
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println(e);
			}
		
		
	}

}
