<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<jsp:include page="ME.jsp"/>
<div class="nav2">

<form name="groupform" action="/example/addgroup" method="post">
Group name:<input type="text" name="groupname"/><br>
Description:<input type="text" name="groupcontent"/><br>
<input type="submit" name="submit">

</form>






</div>
</body>
</html>