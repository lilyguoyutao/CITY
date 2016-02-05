<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String user=(String)session.getAttribute("username");
if(user==null)
	 user=""; %>
<%@ include file="header.jsp" %>
	<div style="width:1200px;height:20px; clear: left;margin-top:200px;"></div>
	<div style="margin-top:100px;margin-left:500px;font-size: 20px;">
		
		<form name="userform"  action="/example/userlogin" method="post">

			Username:<input type="text" name="username" value="<%=user%>"/><br><br>
			Password:<input type="password" name="password"/><br><br>
			Type:<select name="type">
			    <option value="">Please select</option>
                <option value="teacher">teacher</option>
                <option value="writer">student</option>
                
             </select>
			<input type="submit" value="Submit" />
		</form><br>
		<font color="red">${message}</font>
	</div>
</body>
</html>