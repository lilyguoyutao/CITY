<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  <script>
  $(document).ready(function(){
	  
	  $.ajax({
			  
	  type:'GET',
	  url:'/example/getprojectname',
	  contentTyple:'application/json',
	  dataType:'json',
	  success:function(data){
		  var html="<option>all</option>";
		  for(i=0;i<data.length;i++)
			  {
			    html+="<option>"+data[i]+"</option>";
			  }
		  
		  document.getElementById("select").innerHTML = html;
		  
	  },
	  
	  error:function(){
		  alert("error");
	  },
	  
	  
	  });
	  
	  
	  
	  
	  
	  
	  
	  
  });
  
  
  function extend(){
		$("#table").fadeToggle();
	}
  
  
  
  
  
  
 </script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div>
<a style="font-size: 15px" href="/example/browse"><img src="resources/Back.jpg" style="width:30px; height:30px;"></a>
</div>

<div>
<form action="/example/searchthread" method="post">
<table class="table table-hover">
<thead>
<tr><th>Search thread</th><th>&nbsp</th></tr>
</thead>
<tr><td>Thread name:<input type="text" name="name"/>&nbsp&nbsp<a onclick="extend()" href="javascript:">Add more criteria</a></td><td>&nbsp<td><td>&nbsp<td></tr>


</table>
<table id="table" class="table table-hover" style="display:none">
<tr><td>Author:<input type="text" name="author"/></td><td>&nbsp</td><td>&nbsp</td>
</tr>
<tr>
<td>Project:<select id="select" name="project">
    
      </select></td>



</tr>

</table>
<table class="table table-hover" >
<tr>
<td><input type="submit" value="Submit"><td>&nbsp</td><td>&nbsp</td>
</tr>

</table>
</form>
</div>
<div>
<table class="table table-hover">
<thead>
<tr>
<th>Thread_name</th>
<th>Project</th>
<th>Author_name</th>

</tr>
</thead>
<c:forEach var="project" items="${threads}">
<tbody>
<tr><td><a href="/example/threadpage?threadname=${project.threadfocus}">${project.threadfocus}</a></td>

<td>${project.projectname }</td>

<td>${project.author }</td>



</tr>

</tbody>
</c:forEach>

</table>
</div>
</div>

</body>
</html>