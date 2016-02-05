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
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>

<div class="nav2">
<a href="/example/detail?comm_name=${community}"><img src="resources/Back.jpg" style="width:40px; height:40px;"></a>
<div style="margin-left:60px;margin-top:100px;font-size:15px;">

<form action="/example/add" method="post" enctype="multipart/form-data" name="form1">
     
  <input type="file" name="file" /><br><br>
  Community:<input type="text" name="community" value="${community}" readonly="readonly"/>
  <input type="submit" name="submit" value="submit" />   
</form>										
<p>${message}</p>
</div>
</div>
</body>
</html>