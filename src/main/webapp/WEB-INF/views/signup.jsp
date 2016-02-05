<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
body {
	background-color: #C0C0C0;
}

h1 {
	color: #708090;
	text-align: center;
}

p {
	text-align: center;
	font-family: "Times New Roman";
	font-size: 20px;
}

#nav {
	border: solid 1px;
	width: 100px;
	margin-top: 30px;
	background-color: #ccc
}

#nav ul {
	margin-left: -30px;
}

#nav li {
	list-style-type: none; /*display: inline;*/
	margin-top: 13px;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>add student</title>
</head>
<body>
<body>
<div id="nav">
		<ul>
			<li><a href="index.jsp">Back</a></li><!--  
			<li><a href="login.jsp">Login</a></li>
			<li><a href="signup.jsp">Sign Up</a></li> -->
		</ul>
	</div>

	<div>
		<h1>Add Student</h1>

		<p>Fill in all fields:</p>
		<form action='SignupServlet' method='post'>
			
			<label>Username:</label> <br /> 
			<input type='text' name='uname'
				size='30' maxlength='75' value='' />
				<input type="submit" name="checkAV" value="Check Available">
				<br /> <br /> 
				
				<label>First Name:</label><br /> 
				<input type='text' name='fname' size='30'
				maxlength='75' value='' /><br /> <br /> 
				
				<label>Last Name:</label><br />
			<input type='text' name='lname' size='30' maxlength='75' value='' />
			<br />	<br /> 
			
			<label>Password:</label><br /> <input type='password'
				name='password1' size='30' maxlength='16' />
				<br /> <br /> 
				
				<label>Confirm Password:</label><br /> <input type='password' name='password2' size='30'
				maxlength='16' /><br /> <br /> <input type='submit' name='submit'
				value='Add' /><br />
				
				<label>Community:</label><br />
			<input type='text' name='cname' size='30' maxlength='75' value='' />
			<br />	<br /> 
			
								
		</form>
	</div>
	<!-- end main div -->
	<%
		String msg = request.getParameter("msg");
		if (msg == null)
			msg = "";
		if (msg.equals("invalid")) {
			out.println("<p> Please enter correct username and password </p>");
		} else
			out.print(msg);
	%>

</body>
</html>