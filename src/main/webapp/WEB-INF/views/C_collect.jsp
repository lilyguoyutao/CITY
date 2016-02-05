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
<script >
$(document).ready(function(){
	
    $.ajax({
		type:'GET',
		url:'/example/searchcollection?threadname=${threadname}',
		contentType : 'application/json',
        dataType: 'json',
        success: function (data) {
        	
        	var html="<option>--</option>";
        	
        	for(i = 0; i< data.length; i++){
        		html+="<option>"+data[i]+"</option>"
        		
        	}
        	document.getElementById("select").innerHTML = html;
        },
        error:function() {  
          alert("");  
        }  		
		
	});
    




});












</script>
</head>
<body>
<div style="margin-top:10px;">
<form style="margin-left:20px;" action="/example/collectinsert" method="post">
Select a colletion:<select id="select" name="collection" >

</select><br>
<input type="hidden" name="threadname" value="${threadname}"/><br>
<p>Or</p>
   Add a new collection:<input type="text" name="newname"/><br>
<input type="submit" value="submit"/>
</form>
<font style="margin-bottom:10px;">${message}</font>
<div style="height:5px"></div>
</div>
</body>

</html>