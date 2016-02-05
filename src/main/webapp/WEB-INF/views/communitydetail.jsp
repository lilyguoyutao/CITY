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
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>
<%  
     
     String type2=(String)session.getAttribute("type");
     if(type2==null)
    	 type2="";
%>
<div class="nav2">

<table>
<%if(type2.equals("teacher")) {%>
<tr><td><a style="font-size: 15px" href="/example/listcommunity"><img src="resources/Back.jpg" style="width:30px; height:30px;"></a></td>






</tr>
<%}
else
{
%>
<tr><td><a style="font-size: 15px" href="/example/listcommunity"><img src="resources/Back.jpg" style="width:40px; height:40px;"></a></td></tr>
<%} %>
<tr></tr>
<tr>
<td><b>Community_name:</b></td>
<td>${community.community_name}</td>
<td><input name="comccc" type="hidden"/></td>
<td><b>creator:</b></td>
<td>${community.creator}</td>
<td><input name="comccc" type="hidden"/></td>
<td><input name="comccc" type="hidden"/></td>
<td><b>Grade_level:</b></td>
<td>${community.grade_level}</td>

</tr>
<tr><td><input name="comccc" type="hidden"/></td></tr>
<tr>
<td><b>School name:</b></td>
<td>${community.school_name}</td>
<td><input name="comccc" type="hidden"/></td>
<td><b>School_phone:</b></td>
<td>${community.school_phone}</td>


</tr>
<tr><td><input name="comccc" type="hidden"/></td></tr>
<tr>
<td><b>Address:</b></td>
<td>${community.street}</td>
<td>${community.city}</td>
<td>${community.state}</td>
<td>${community.country}</td>
<td></td>

</tr>
<tr><td></td><td></td><td></td></tr>
<tr><td></td><td></td><td></td></tr>

</table>

<div style="height:10px;"></div>
<%if(type2.equals("teacher")) {%>
<div style="height:40px;border-bottom:1px solid">

<table>
<tr>
<td><div style="width:800px"></div></td>
<td><b><a style="font-size: 15px" href="/example/add?com_name=${community.community_name}"><img src="resources/upload.jpg" style="width:40px; height:30px;"></a></b></td>
<td><b><a style="font-size: 15px" href="/example/download?com=${community.community_name}"><img src="resources/download.png" style="width:30px; height:30px;"></a></b></td>
</tr>
</table>

</div>
<% }%>
<iframe src="/example/listuser?coname=${community.community_name}"  width=900px height=300px style="border:1px black">

</iframe>

</div>
</body>
</html>