package servlets;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import entity.Book;
import extras.DBConnection;

/**
 * Servlet implementation class AddBook
 */
@WebServlet("/AddBook")
@MultipartConfig
public class AddBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletFileUpload uploader = null;
    @Override
	public void init() throws ServletException{
		DiskFileItemFactory fileFactory = new DiskFileItemFactory();
		File filesDir = (File) getServletContext().getAttribute("FILES_DIR_FILE");
		fileFactory.setRepository(filesDir);
		this.uploader = new ServletFileUpload(fileFactory);
	}
       
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
		response.setContentType("text/html");
		if(!ServletFileUpload.isMultipartContent(request)){
			throw new ServletException("Content type is not multipart/form-data");
		}
		PrintWriter out = response.getWriter();
		Book b = new Book();
		DBConnection dbConnection = new DBConnection();
		try {
			List<FileItem> fileItemsList = uploader.parseRequest(request);
			Iterator<FileItem> fileItemsIterator = fileItemsList.iterator();
			while(fileItemsIterator.hasNext()){
				FileItem fileItem = fileItemsIterator.next();
				if(fileItem.isFormField()) {
					String fieldName = fileItem.getFieldName();
	                String fieldValue = fileItem.getString();
	                if (fieldName.equals("book_name")) {
	                	b.setBook_name(fieldValue);							
					}else if(fieldName.equals("author")) {
						b.setAuthor(fieldValue);
					}else if (fieldName.equals("price")) {
						b.setPrice(Integer.parseInt(fieldValue));
					}else if (fieldName.equals("description")) {
						b.setDescription(fieldValue);
					}else if (fieldName.equals("sell_type")) {
						b.setSell_type(fieldValue);
					}else if (fieldName.equals("type")) {
						b.setType(fieldValue);
					}
				}else {
				
				System.out.println("FieldName="+fileItem.getFieldName());
				System.out.println("FileName="+fileItem.getName());
				System.out.println("ContentType="+fileItem.getContentType());
				System.out.println("Size in bytes="+fileItem.getSize());
				
				File file = new File(request.getServletContext().getAttribute("FILES_DIR")+File.separator+fileItem.getName());
				System.out.println("Absolute Path at server="+file.getAbsolutePath());
				fileItem.write(file);
				b.setImage("URL OF ASD");
				}
			}
				
				
			
			b.setEmail((String)request.getSession().getAttribute("email"));
			b.setBook_id(UUID.randomUUID().toString().replaceAll("-", ""));
			dbConnection.create();
			boolean flag = dbConnection.addBook(b);
			if(flag) {
				out.println("<script> "
						+ "alert(\"Book Added Successfully\");"
						+ "</script>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else {
				out.println("<script> "
						+ "alert(\"Book Added Successfully\");"
						+ "</script>");
				request.getRequestDispatcher("sell_book.jsp").include(request, response);
			}
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println(e1);
		}/*
		String x = request.getParameter("price");
		
		Book b = new Book();
		b.setAuthor(request.getParameter("author"));
		b.setBook_id(UUID.randomUUID().toString().replaceAll("-", ""));
		b.setBook_name(request.getParameter("book_name"));
		b.setDescription(request.getParameter("description"));
		b.setEmail((String)request.getSession().getAttribute("email"));
		b.setImage(request.getParameter("image"));
		b.setPrice(Integer.parseInt(x));
		b.setSell_type(request.getParameter("sell_type"));
		b.setType(request.getParameter("type"));
		DBConnection dbConnection = new DBConnection();
		try {
			dbConnection.create();
			boolean flag = dbConnection.addBook(b);
			if(flag) {
				out.println("<script> "
						+ "alert(\"Book Added Successfully\");"
						+ "</script>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			}
			else {
				out.println("<script> "
						+ "alert(\"Book Added Successfully\");"
						+ "</script>");
				request.getRequestDispatcher("sell_book.jsp").include(request, response);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
		*/
		
		
	}

}
