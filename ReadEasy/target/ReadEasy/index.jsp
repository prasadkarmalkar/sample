<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>ReadEasy</title>
<script src="js/bootstrap.js"></script>
<link href="css/bootstrap.css" type="text/css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>

    </head>
    <style>
        .s{
            position: absolute;
            left: 90%;
        }
        .s1{
            position: absolute;
            left: 83%;
        }
        .sbook{
            position:absolute;
            left: 35%;
        }
    </style>
    <body>
            <nav class="navbar navbar-expand-sm bg-primary navbar-light">
                    <a class="navbar-brand" href="#"><h1>ReadEasy</h1></a>
                    <div class="sbook">
                    <form class="form-inline" action="#">
                        <input class="form-control mr-sm-2" type="text" placeholder="Search Books">
                        <button class="btn btn-success" type="submit">Search</button>
                      </form>
                    </div>
      <% 
                    	Cookie ck[] = request.getCookies();
                    		try{
                    	 	String name =	ck[2].getValue();
                    	 	out.print("<div class=\"dropdown\">"+
                    	 			  "<button type=\"button\" class=\"btn btn-danger dropdown-toggle s\" data-toggle=\"dropdown\">"+
                    	    name+
                    	 " </button>"+
                    	 " <div class=\"dropdown-menu\">"+
                    	    "<a class=\"dropdown-item\" href=\"/FYP/SignOut\">Sign Out</a>"+
                    	   " <a class=\"dropdown-item\" href=\"#\">Link 2</a>"+
                    	   " <a class=\"dropdown-item\" href=\"#\">Link 3</a>"+
                    	 " </div>	</div>");
                    		}catch(Exception e){ out.print("<a href=\"user_login.html\"><button class=\"btn btn-secondary s\" >Sign In</button></a>");}

                    
                    %>
                    <a href="user_signup.html"><button class="btn btn-secondary s1" >Sign Up</button></a>

                  </nav>
    </body>
</html>