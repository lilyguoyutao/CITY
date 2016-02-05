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
<script>

function fetch(ideaname){
	
	  
	  $.ajax({
		  
		  type:'GET',
		  url:'/example/ideacomment?ideaname='+ideaname,
		  contentTyple:'application/json',
		  dataType:'json',
		  success:function(data){
			  var html="";
			  for(i=0;i<data.length;i++)
				  {html+="<div style='width:800px; border:groove 3px; margin-top:10px'><p>"+data[i].me_text+"</p>";
				   html+="&nbsp at &nbsp <a href='#'>"+data[i].time+"</a> &nbsp by &nbsp <a href='#'>"+data[i].author+"</a></p></div>"
				  
				  
				  }
			  
			  document.getElementById(ideaname).innerHTML = html;
			  
		  },
		  
		  error:function(){
			  alert("error");
		  },
		  
		  
		  });
	  var idewa="#"+ideaname
	  $(idewa).fadeToggle();
	 
}

</script>
</head>
<body>

<div style="margin-left:600px">
<form action="/example/searchidea" method="post"><input type="text" name="search" value="${searchme}"/><input type="hidden" name="threadname" value="${threadname}"><input type="submit" value="search"/></form>
</div>
<c:forEach var="idea" items="${list}">
<div style="background:#ccc; margin-top:20px;">
<form name="ideaform" action="/example/comment" method="post">
<table >
<tr><td>&nbsp</td></tr>
<tr><td> ${idea.notetitle} create  at ${idea.createtime}</td></tr>
<tr><td>&nbsp</td></tr>
</table>
<textarea id="message22" rows="6" cols="100"
										name="message22" readonly="readonly">${idea.notecontent}</textarea>
<table >
<tbody>



<tr><td>&nbsp</td></tr>

<tr><td><div style="width:20px"></div></td><td >

<textarea id="message" rows="3" cols="50"
										name="message" placeholder="write a comment"></textarea>
<input type="hidden" name="idea2" value="${idea.noteid}">
<input type="hidden" name="search3" value="${searchme}">
<input type="hidden" name="threadname" value="${threadname}">
</td>

</tr>
<tr><td><div style="width:330px"></div><td><input type="submit" value="Submit"/></td></tr>
<tr><td>&nbsp</td></tr>

</tbody>
</table>
</form>
<a onclick="fetch('${idea.noteid}')" href="javascript:"  style="margin-top:5px;"><font>Check all the comments</font></a>
<div id="${idea.noteid}" style="display:none"></div>
<div style="height:5px"></div>
</div>
</c:forEach>
</body>

</html>