<%@page import="java.sql.ResultSet"%>
<%@page import="extras.DBConnection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReadEasy</title>
<script src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

</head>
<style>
.s {
	position: absolute;
	left: 90%;
}

.s1 {
	position: absolute;
	left: 83%;
}

.sbook {
	position: absolute;
	left: 35%;
}
</style>
<body>
	<nav class="navbar navbar-expand-sm bg-primary navbar-light">
		<a class="navbar-brand" href="#"><h1>ReadEasy</h1></a>
		<div class="sbook">
			<form class="form-inline" action="#">
				<input class="form-control mr-sm-2" type="text"
					placeholder="Search Books">
				<button class="btn btn-success" type="submit">Search</button>
			</form>
		</div>
		<%
			HttpSession session1 = request.getSession(false);
			String email = (String) session1.getAttribute("email");
			if (email != null) {

				out.print("<div class=\"dropdown\">"
						+ "<button type=\"button\" class=\"btn btn-danger dropdown-toggle s\" data-toggle=\"dropdown\">"
						+ email + " </button>" + " <div class=\"dropdown-menu\">"
						+ "<form action=\"SignOut\" method=\"post\"><input type=\"submit\" value=\"Log Out\" class=\"dropdown-item\"></form>"
						+ " <a class=\"dropdown-item\" href=\"#\">Link 2</a>"
						+ " <a class=\"dropdown-item\" href=\"#\">Link 3</a>" + " </div>	</div>");
			} else {
				out.print("<a href=\"user_login.jsp\"><button class=\"btn btn-secondary s\" >Sign In</button></a>");
			}
		%>
		<a href="user_signup.html"><button class="btn btn-secondary s1">Sign
				Up</button></a>

	</nav>
	<%!DBConnection dbConnection = new DBConnection();
	ResultSet s;%>
	<div class="card-columns">
		<%
			dbConnection.create();
			s = dbConnection.executeQuery("select book_id,book_name,sell_type,price,image from book;");
			while (s.next()) {
		%>
		<div class="card bg-light" style="width: 200px">
			<img class="card-img-top" src="<%=s.getString("image")%>"
				alt="Card image" width="200px" height="200px">
			<div class="card-body">
				<h6
				 class="card-title"><%=s.getString("book_name")%></h6>
				<h6>
					Price :<%=s.getString("price")%>Rs
				</h6>
				<p><%=s.getString("sell_type")%></p>
				<a value="Add To Cart" class="btn btn-outline-success">Add to Cart</a>
			</div>
			
		</div>
		<%
			}
			s.close();
		%>
	</div>
	
	Hey I am changing csomething
</body>
</html>