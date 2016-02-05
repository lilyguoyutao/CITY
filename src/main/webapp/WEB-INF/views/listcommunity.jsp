<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="resources/Style.css" rel='stylesheet' type='text/css' />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
<style>
#customers {
    font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
    width: 100%;
    border-collapse: collapse;
    margin-left:20px;
}

#customers td, #customers th {
    font-size: 1em;
    border-bottom: 1px solid #98bf21;
    border-right: 1px solid #98bf21;
    padding: 3px 7px 2px 7px;
}

#customers th {
    font-size: 1.1em;
    text-align: left;
    padding-top: 5px;
    padding-bottom: 4px;
    background-color: #A7C942;
    color: #ffffff;
}


</style>

</head>
<body>
<%String type3=(String)session.getAttribute("type");
     if(type3==null)
    	 type3="";%>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>

<div class="nav2">
<div style="margin-top:20px;margin-left:10px;">
							<table class="table table-hover" >
								<thead>
									<tr>
										<th>Community__name</th>
										<th>creator</th>
										<th>School</th>
										<th>detail</th>
										
									</tr>
								</thead>
								<tbody>
									<c:forEach var="community" items="${listcommunity}">
										<tr>
											<td>${community.community_name}</td>
											<td>${community.creator}</td>
											<td>${community.school_name}</td>
											<td><a href="/example/detail?comm_name=${community.community_name}">detail</a></td>
											
										</tr>
									</c:forEach>
								</tbody>
						</table>
</div>						
</div>					
</body>
</html>