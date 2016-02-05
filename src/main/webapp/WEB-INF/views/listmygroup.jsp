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
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div style="margin-top:20px;margin-left:10px;">
							<table class="table table-hover" >
								<thead>
									<tr>
										<th>group__name</th>
										<th>creator</th>
										<th>description</th>
										
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="group" items="${listgroup}">
										<tr>
											<td><a href="/example/groupdetail?groupid=${group.group_id}">${group.group_name}</a></td>
											<td>${group.group_builder}</td>
											<td>${group.group_content}</td>
											
										</tr>
									</c:forEach>
								</tbody>
						</table>
</div>
</div>						
</body>
</html>