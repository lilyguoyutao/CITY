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
	  url:'/example/listcommunityname?threadname=${threadname}',
	  contentTyple:'application/json',
	  dataType:'json',
	  success:function(data){
		  
		  var html="";
		  for(i=0;i<data.length;i++)
			  {
			    html+="<option>"+data[i]+"</option>"
			  }
		  document.getElementById("select").innerHTML = html;
		  
	  },
	  
	  error:function(){
		  alert("error");
	  },
	  
	  
	  });
	  

	  
	  
	  
	  
	  
	  
});
</script>
</head>

<body>
<div style="width:400px;heigth:100px;margin-left:20px;margin-top:20px">
<form action="/example/insertadopt" method="post">
<p>Would you like to recommend &nbsp<a href="/example/threadpage?threadname=${threadname}">${threadname}</a> to</p>
<select id="select" name="community">

</select>
<input type="hidden" name="threadname" value="${threadname}"><br><br>
Why you recommend this thread:<br>
<textarea rows="3" cols="30" name="reason"></textarea><br><br>
<input type="submit" value="adopt"/>


</form>
<font color="red">${from}</font>
<div style="height:5px">&nbsp</div>
</div>
</body>
</html>