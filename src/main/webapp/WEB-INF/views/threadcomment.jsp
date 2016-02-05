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
<div style="margin-top:10px;margin-left:10px">
<form action="/example/tcomment" method="post">
<textarea rows="3" cols="50" name="mess" placeholder="write a comment for this thread"></textarea>
<input type="hidden" name="threadname" value="${threadname}"><br>

<input type="submit" name="submit" value="submit"/><br>


</form>
<div style="width:380px">&nbsp</div>

<c:forEach var="item" items="${listcomment}">
<div style="border:groove 3px;width:300px; margin-top:5px">
<p>${item.me_text} <font color='red'>by<a href="#"> ${item.author} </a>at <a href="#">${item.time }</a></font></p>

</div>
</c:forEach>
<div style="height:5px">&nbsp</div>
</div>
</body>
</html>