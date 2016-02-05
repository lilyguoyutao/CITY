<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="resources/js/artDialog4.1.7/artDialog.js?skin=twitter" type="text/javascript"></script>
<script src="resources/js/artDialog4.1.7/plugins/iframeTools.js" type="text/javascript"></script>
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
  
<script>

$(document).ready(function(){
	$.ajax({
		
		type:'GET',
		url:'/example/listcollect',
		contentType : 'application/json',
	    dataType: 'json',
	    success: function (data) {
	    	
	    	for(i=0;i<data.length;i++)
	    	document.getElementById(data[i]).click();
	    },
	    error:function() {  
	      alert("");  
	    }  		
				
		
		
		
		
		
		
		});

});

function tabletoggle(){
	$("#table1").fadeToggle();
}

function tabletoggle2(){
	$("#table2").fadeToggle();
}
function tabletoggle3(){
	$("#table3").fadeToggle();
}
function tabletoggle4(){
	$("#table4").fadeToggle();
}
function collect(mycollect){
	$.ajax({
		
	type:'GET',
	url:'/example/mycollectthread?collectid='+mycollect,
	contentType : 'application/json',
    dataType: 'json',
    success: function (data) {
    	
    	var html="";
    	
    	for(i = 0; i< data.length; i++){
    		
    		html += "<tr><td><a href='/example/threadpage?threadname="+data[i].threadname+"'>"+data[i].threadname+"</a></td><td>"+data[i].projectname+" </td><td>"+data[i].communityname+"</td></tr>";
    		
    		
    	}
    	document.getElementById(mycollect).innerHTML = html;
    },
    error:function() {  
      alert("");  
    }  		
			
	
	
	
	
	
	
	});
	//var nae="#"+mycollect;
	//$(nae).fadeToggle();
	
};

function addition(){ 
	   
	art.dialog.open('/example/addition', {title: 'Add collection'});
	
}
function collectrecomment(collectname){ 
	   
	art.dialog.open('/example/recomendcollect?collectname='+collectname, {title: 'Add collection'});
	
}
</script>
</head>
<body >
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px;"></div>
<jsp:include page="ME.jsp"/>

 
<div class="nav2">

<div id="like" style="border-bottom:solid 1px">

<h4><a onclick="tabletoggle();" href="javascript:">Idea thread I liked</a></h4>

<div id="table1" style="display:none">
							<table >

								<tbody>
									<c:forEach var="like" items="${likelist}">
										<tr>
											
											<td><a href="/example/threadpage?threadname=${like.thread}">${like.thread}</a></td>
											
											
										</tr>
									</c:forEach>
								</tbody>
						</table>

</div>
</div>

<div style="border-bottom:solid 1px;margin-top:20px">
<h4><a onclick="tabletoggle4();" href="javascript:">My collection of idea thread</a></h4>
<div id="table4" >
<c:forEach var="item" items="${collect}">
<div style="width:300px;height:150px;border:outset 3px grey;float:left; margin-left:10px">
<h4><b>${item.collectname}</b>&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<a onclick="collectrecomment('${item.collectname}')" href="javascript:"><img style="width:50px;height:25px"src="resources/bluebutton.png"></a></h4>
<a id="${item.collectname}" onclick="collect('${item.id}')" href="javascript:">&nbsp</a>
<table id="${item.id}"></table>
</div>

</c:forEach>
<div style="width:200px;height:150px;border:outset 3px grey;float:left; margin-left:10px">
<div style="margin-bottom:50px">&nbsp</div>
<a href="/example/addition" style="padding-left:55px;margin-top:60px;"><font size="3" color="black">Add new</font></a>
</div>
<div style="clear:left"></div>
</div>

</div>
<div id="follow" style="border-bottom:solid 1px;margin-top:20px">

<h4><a onclick="tabletoggle2();" href="javascript:">Idea thread I am following</a></h4>

	<div id="table2" style="display:none">				
	                 <table >

								<tbody>
									<c:forEach var="like" items="${update}">
										<tr>
											
											<td><a href="/example/threadpage?threadname=${like.thread}">${like.thread}</a></td>
											<td>&nbsp ${like.body}</td>
											<td>&nbsp at ${like.time1 }</td>
											
										</tr>
									</c:forEach>
								</tbody>
						</table>

</div>	

</div>
<div style="border-bottom:solid 1px;margin-top:20px">
<h4><a onclick="tabletoggle3();" href="javascript:">Idea thread recommended by my community</a></h4>
<div id="table3" style="display:none">
							<table >

								<tbody>
									<c:forEach var="like" items="${adopt}">
										<tr>
											<td><a href="/example/threadpage?threadname=${like.threadname}">${like.threadname}</a></td>
											<td>&nbsp is recommended to</td>
											<td>&nbsp your Community of &nbsp </td>
											<td><a href="/example/detail?comm_name=${like.community}">${like.community}.</a></td>
											<td>&nbsp &nbsp &nbsp &nbsp <b>Reason:</b> </td>
											<td>&nbsp ${like.reason} </td>
											
										</tr>
										
									</c:forEach>
								</tbody>
						</table>

</div>

</div>
</div>
</body>
</html>