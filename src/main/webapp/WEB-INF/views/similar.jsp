<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="resources/css/amazon_scroller.css" rel="stylesheet" type="text/css"></link>
<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
<script type="text/javascript" src="resources/js/amazon_scroller.js"></script>
<!--script>

$(document).ready(function(){
	$.ajax({
		  
		  type:'GET',
		  url:'/example/similarfindbar?threadname=${threadname}',
		  contentType:'application/json',
		  dataType:'json',
		  success:function(data){
			   var html="";
			  for(i=0;i<data.length;i++)
				  
			  { 
				  html+="<li><a href='/example/threadpage?threadname="+data[i]+"'>"+"<div style=width:100px;height:100px>"+data[i]+"</div></a></li>";
			    
			  }
			  document.getElementById("list").innerHTML = html;
	
			  
			  
		  },
		  
		  error:function(){
			  alert("error");
		  },
		  
		  
		  });
	
});
</script>-->
</head>
<body>
<script language="javascript" type="text/javascript">

            $(function() {
                $("#amazon_scroller1").amazon_scroller({
                    scroller_title_show: 'enable',
                    scroller_time_interval: '4000',
                    scroller_window_background_color: "#FFFFFF",
                    scroller_window_padding: '10',
                    scroller_border_size: '1',
                    scroller_border_color: '#000',
                    scroller_images_width: '124',
                    scroller_images_height: '160',
                    scroller_title_size: '12',
                    scroller_title_color: 'black',
                    scroller_show_count: '6',
                    directory: 'images'
                });
				
            });
        </script>
        <div id="amazon_scroller1" class="amazon_scroller">
            <div class="amazon_scroller_mask">
                <ul >
                    <c:forEach var="combin" items= "${threadlist}">
                    <li><a href="/example/threadpage?threadname=${combin.threadname}" title="">${combin.threadname}</a></li>
                    </c:forEach>
                </ul>
            </div>
            <ul class="amazon_scroller_nav">
                <li></li>
                <li></li>
            </ul>
            <div style="clear: both"></div>
        </div>
</body>
</html>