<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div style="width:600px;">

<c:forEach var="likeq" items="${listlike}">
<div style="width:150px; border:solid 1px; float:left; margin-left:5px">
<p>${likeq.username}</p>


</div>




</c:forEach>



</div>
</body>
</html>