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
<div style="width:1200px;height:20px;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div style="width:400px;float:left">
<%  String Loginin=(String)session.getAttribute("iflogin");
     if(Loginin==null)
    	 Loginin="";
     String user=(String)session.getAttribute("username");
     if(user==null)
    	 user="";
     String type=(String)session.getAttribute("type");
     if(type==null)
    	 type="";
     String con1=(String)session.getAttribute("con1");
     if(con1==null)
    	 con1="";
     String con2=(String)session.getAttribute("con2");
     if(con2==null)
    	 con2="";
%>



<%if(type.equals("teacher")) {%>
<form name="edit" action="/example/edit" method="post">
<table>
		
		<tr><td>	<b>Username:</b></td><td><input type="text" name="user" value="${student.username}"/></td></tr>
		<tr><td>	<div style="width:30px;height:20px"></div></td></tr>
		<tr><td><b>Change Password:</b></td><td><a href="/example/changepass" style="text-decoration:none"><img src="resources/pass.png" style="width:40px; height:30px;"></a></td></tr>
		<tr><td>	<div style="width:30px;height:20px"><input type="hidden" name="password" value="${student.password}"/></div></td></tr>
		<tr><td>	<b>Firstname:</b></td><td><input type="text" name="firstname" value="${student.firstname}"/></td></tr>
		<tr><td>	<div style="width:30px;height:20px"></div></td></tr>
		<tr><td>	<b>LastName:</b></td><td><input type="text" name="lastname" value="${student.secondname}"/></td></tr>
			<tr><td>	<div style="width:30px;height:20px"></div></td></tr>
		 <tr><td>   <b>School:</b></td><td><input type="text" name="school" value="${student.school}"/></td></tr>
		    <tr><td>	<div style="width:30px;height:20px"></div></td></tr>
		 <tr><td>   <b>Email:</b></td><td><input type="text" name="email" value="${student.email}"/></td></tr>
		   <tr><td>	<div style="width:30px;height:20px"></div></td></tr>
		  <tr><td>  <input type="submit" value="Save change"/></td><td>
		    </td></tr>
		
		
</table>		
	
	</form>
	
	<p>${message}</p>
<%} else{%>
 <table>
 <tr><td><b>Username</b></td>
 <td>${student.username }</td>
 <td><input type="hidden" name="passw" value=""/><br></td></tr>
 <tr>
 <td><b>Firstname</b></td>
 <td>${student.firstname }</td>
 <td><input type="hidden" name="passw" value=""/><br></td></tr>
<tr> <td><b>Lastname</b></td>
 <td>${student.secondname }</td>
 </tr>
 <tr>
 <td><b>School</b></td>
 <td>${student.school}</td>
 <td><input type="hidden" name="passw" value=""/><br></td></tr><tr>
 <td><b>Email</b></td>
 <td>${student.email }</td>
 
 
 </tr>
 </table>
 
 <% }%>
 

</div>
 <div style="float:left">

<iframe src="/example/showinterestpage"  width=410px height=300px style="border:1px black; background:#F2F2F2">

</iframe>


</div>

</div>
	
</body>
</html>