<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/js/artDialog4.1.7/artDialog.js?skin=twitter" type="text/javascript"></script>
<script src="resources/js/artDialog4.1.7/plugins/iframeTools.js" type="text/javascript"></script>
<script>
$(document).ready(function(){
	  
	  $.ajax({
			  
	  type:'GET',
	  url:'/example/whetherlike?thread=${threadname}',
	  contentType:'application/json',
	  dataType:'json',
	  success:function(data){
		  var html="";
		  if(data[0]==0)
			  {html="<a href='/example/likeme?threadname=${threadname}'>like</a><a  onclick='likewin()' href='javascript:'>("+data[1]+")</a>"}
		  else
			  {html="<a href='/example/dislikeme?threadname=${threadname}'>dislike</a><a onclick='likewin()' href='javascript:'>("+data[1]+")</a>"}
		  
		  document.getElementById("like").innerHTML = html;
		  
	  },
	  
	  error:function(){
		  alert("error");
	  },
	  
	  
	  });
	  
	  $.ajax({
		  
		  type:'GET',
		  url:'/example/checkfollow?thread=${threadname}',
		  contentType:'application/json',
		  dataType:'json',
		  success:function(data){
			  var html="";
			  if(data==true)
				  {html="<a href='/example/follow?threadname=${threadname}'>follow</a>"}
			  else
				  {html="follow"}
			  
			  document.getElementById("follow").innerHTML = html;
			  
		  },
		  
		  error:function(){
			  alert("error");
		  },
		  
		  
		  });
	  
	  
	  
	  
	  
});

function openPage(){ 
	   
	art.dialog.open('/example/threadcomment?threadname=${threadname}', {title: 'Comment'});
	//要传递数据到里一个页面可以通过data来实现 
	
	//打开窗口 
	/*art.dialog.open({
		title:'dialog',
	//	content:'<form action="Footer.jsp" method="post">'+
		'<input type="text" name="cc"/>'+'<input type="submit" value="submit"/>'+'</form>'
	});*/
}
function likewin(){ 
	   
	art.dialog.open('/example/likelist?threadname=${threadname}', {title: 'likelist'});
	
}

function adopt(){ 
	   
	art.dialog.open('/example/adopt?threadname=${threadname}', {title: 'Adopt'});
	
}

function collect(){ 
	   
	art.dialog.open('/example/showcollection?threadname=${threadname}', {title: 'Collect'});
	
}




</script>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div style="background:#F2F2F2">
<img src="resources/notepic.png" Style="width:400px; height:200px;margin-left:200px">
<table style="margin-left:260px">

<tr>

<td id="like"></td>
<td >&nbsp</td>
<td id="follow"></td>
<td >&nbsp</td>
<td><a href="javascript:" onclick="openPage()">Comment</a></td>
<td >&nbsp</td>
<td><a onclick="collect()" href="javascript:">Collect</a></td>
<td >&nbsp</td>
<td><a onclick="adopt()" href="javascript:">Adopt</a></td>
<td >&nbsp</td>
<td >&nbsp</td>
<td >&nbsp</td>
<td >&nbsp</td>
<td >&nbsp</td>




</tr>
</table>
<iframe src="/example/similarfindbar?threadname=${threadname}"  width=900px height=90px style="border:1px black; background:#FFFFFF">

</iframe>
</div>
<div style="width:1200px;height:10px;">


</div>


<iframe src="/example/listidea?threadname=${threadname}"  width=900px height=800px style="border:5px dotted line;padding-left:5px; background:#ccc">

</iframe>


</div>
</body>
</html>