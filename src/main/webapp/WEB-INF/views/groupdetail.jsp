<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<h4>${group.group_name }</h4>
<table>
<tr>
<td><div style="width:800px"></div></td>
<td><b><a style="font-size: 15px" href="/example/addgroup?groupid=${group.group_id}"><img src="resources/upload.jpg" style="width:40px; height:30px;"></a></b></td>
<td><b><a style="font-size: 15px" href="/example/downloadgroup?groupid=${group.group_id}"><img src="resources/download.png" style="width:30px; height:30px;"></a></b></td>
</tr>
</table>
<iframe src="/example/groupuserlist?groupid=${group.group_id}"  width=900px height=300px style="border:1px black">

</iframe>
</div>
</body>
</html>