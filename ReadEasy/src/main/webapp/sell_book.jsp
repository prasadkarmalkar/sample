<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sell Book</title>
<script src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">

</head>
<style>
.container {
	width: 40%;
	margin-left: 5%;
	margin-top: 5%;
}
</style>
<body>
	<%
		String email = (String) session.getAttribute("email");
		if (email == null) {
			out.println("<script> alert(\"Login First\"); </script>");
			response.sendRedirect("user_login.jsp");
		}
	%>
	<div class="container alert-secondary">
		<h2>Sell A Book</h2>
		<form action="AddBook" class="was-validated" method="post"
			enctype="multipart/form-data">
			<div class="form-group">
				<label for="book_name">Book Name:</label> <input type="text"
					class="form-control" id="book_name" placeholder="Enter Book Name"
					name="book_name" required>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="author">Book Author:</label> <input type="text"
					class="form-control" id="author" placeholder="Enter Author Name"
					name="author" required>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="sell_type">Book Selling Type:</label> <select
					class="form-control" name="sell_type" id="sell_type">
					<option class="form-input">New</option>
					<option class="form-input">Used</option>
				</select>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="price">Book Price:</label> <input type="number"
					class="form-control" id="price" placeholder="Enter Book Price In INR"
					name="price" min="0.00" max="10000.00" step="0.01" required><p>&#8377;</p></input>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="description">Book Description:</label>
				<textarea type="text" class="form-control" id="description"
					placeholder="Enter Book Description" name="description" rows="5"
					required></textarea>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="type">Book Type:</label> <select class="form-control"
					name="type" id="type">
					<option class="form-input">Children's & Young</option>
					<option class="form-input">Literature & Fiction</option>
					<option class="form-input">Exam Preparation</option>
					<option class="form-input">Comics</option>
					<option class="form-input">Textbooks & Study Guides</option>
					<option class="form-input">Crime, Thriller & Mystery</option>
					<option class="form-input">Biographies, Diaries & True
						Accounts</option>
					<option class="form-input">Business & Economics</option>
					<option class="form-input">Sciences, Technology & Medicine</option>
					<option class="form-input">Art, Film & Photography</option>
				</select>
				<div class="invalid-feedback">Please fill out this field.</div>
			</div>
			<div class="form-group">
				<label for="image">Book Image:</label>
				<div class="custom-file">
					<input type="file" class="custom-file-input" id="image"
						name="image" multiple> <label class="custom-file-label"
						for="customFile">Choose Image File</label>
				</div>
			</div>
			<div class="form-group form-check">
				<label class="form-check-label"> <input
					class="form-check-input" type="checkbox" name="remember" required>
					I agree on blabla.
					<div class="valid-feedback">Valid.</div>
					<div class="invalid-feedback">Check this checkbox to
						continue.</div>
				</label>
			</div>
			<button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>