<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
<form action="/example/addtogroupm" method="POST">



<table class="table table-hover">
<thead>
<tr>
<th>********</th>
<th>Username</th>
<th>Password</th>
<th>First_name</th>
<th>Last_name</th>
<th>School</th>
<th>Email</th>




</tr>

</thead>
<tbody>
<c:forEach var="user" items= "${userlist}">
<tr >
<td><img src="resources/confirmation.png" style="width:20px; height:20px;"></td>
<td>${user.username }</td>
<td>${user.password }</td>
<td>${user.firstname}</td>
<td>${user.secondname}</td>
<td>${user.school}</td>
<td>${user.email}</td>

</tr>


</c:forEach>

<tr>
<td><input type="submit" name="submit" value="add"/></td>
<td><input type="text" name="username"/></td>
<td><input type="text" name="password"/></td>
<td><input type="text" name="firstname"/></td>
<td><input type="text" name="secondname"/></td>
<td><input type="text" name="school"/></td>
<td><input type="text" name="email"/></td>





</tr>
<tr>
<td><input type="hidden" name="groupid" value="${groupid}"/></td>

</tr>

</tbody>
</table>
</form>
</body>
</html>