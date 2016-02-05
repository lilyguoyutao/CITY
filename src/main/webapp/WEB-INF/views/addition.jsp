<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
 <script> 
$(document).ready(function(){
	   $.ajax({
		   type:'GET',
		   url:'/example/findallthreadforcollection',
		   contentType:'application/json',
		   dataType:'json',
		   success:function(data){
			   var html="";
			   for(i=0;i<data.length;i++){
				   html+="<option>"+data[i]+"</option>";
			   }
			  
			   document.getElementById("select").innerHTML=html;
		   },
		   error:function(){
			   alert("error");
		   },
		  
	  
	   
	   
	   });
	   
  





});

</script> 
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div style="margin-left:300px;margin-top:150px;border:solid 1px;padding:30px">
<p>Add new collection</p>
<form action="/example/addition" method="post">
New name: <input type="text" name="collectname" /><br>
<br>
Add description:<br>
<textarea name="disc" rows="3" cols="60" placeholder="Add description"></textarea><br>
<br>
Add thread:<br>
<select id="select" name="threads" size="4" multiple>

</select><br><br>

<input type="submit" name="submit" value="Add">
</form>
</div>
</div>
</body>
</html>