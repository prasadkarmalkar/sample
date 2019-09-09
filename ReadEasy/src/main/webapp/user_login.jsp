<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<script src="js/bootstrap.js" type="text/javascript"></script>
</head>
<style>
.card {
	position: absolute;
	top: 50%;
	left: 50%;
	/* bring your own prefixes */
	transform: translate(-50%, -50%);
}

.body {
	background-color: gray;
}
</style>
<body>
	<div class="card" style="width: 400px">
		<div class="card-body">

			<center>
				<h1>
					<kbd>ReadEasy</kbd>
				</h1>
				<br>
				<h3 class="title">User Login</h3>
			</center>
			<br>
			<form action="SignIn" method="post">
				<div class="form-group">
					<label for="email">Email address:</label> 
					<input type="email"	class="form-control" id="email" name="email">
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" name="password">
				</div>
				<div class="form-group">
					<button type="submit" class="form-control btn-primary">Submit</button>
				</div>

			</form>
		</div>
	</div>
</body>
</html>