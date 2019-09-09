package servlets;

import java.io.File;
import java.io.IOException;
import org.apache.commons.fileupload.FileItem;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Book;
import extras.DBConnection;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddBook() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletFileUpload sf = new ServletFileUpload(new DiskFileItemFactory());
		List<FileItem> files = sf.parseRequest(request);
		for(FileItem file : files) {
			item.write(new File("C:\\Users\\Satta\\eclipse-workspace\\ReadEasy\\images\\"+file.getName()));
			
			
		}
	/*	DBConnection dbConnection = new DBConnection();
		Book b = new Book();
		b.setAuthor(request.getParameter("author"));
		b.setBook_id(request.getParameter("book_id"));
		b.setBook_name(request.getParameter("book_name"));
		b.setDescription(request.getParameter("description"));
		b.setEmail(request.getParameter("email"));
		b.setImage(request.getParameter("email"));
		b.setPrice(request.getParameter("price"));
		b.setSell_type(request.getParameter("sell_type"));
		b.setType(request.getParameter("type"));
		dbConnection.create();
		dbConnection.addBook(b);
		dbConnection.close();*/
		
	}

}
