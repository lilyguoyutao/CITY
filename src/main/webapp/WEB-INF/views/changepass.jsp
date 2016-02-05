<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function onpass(){
	if(document.passwo.new1.value!=document.passwo.new2.value)
		{
		    window.alert("new password is not same")
		    return false;
		}
	return true;
}


</script>
</head>
<body>
<%@ include file="header.jsp" %>
<div style="width:1200px;height:20px; clear: left;"></div>
<jsp:include page="ME.jsp"/>
<div class="nav2">
<div style="margin-top:100px;margin-left:300px">

<form name="passwo" action="/example/changepass" method="post"> 
<table>
<tr><td>Old password:</td><td><input type="password" name="old"/></td></tr>
<tr><td>New password:</td><td><input type="password" name="new1"></td></tr>
<tr><td>Confirmed password:</td><td><input type="password" name="new2"></td></tr>
<tr><td><input type="submit" value="submit" onclick="return onpass()"></td></tr>
 
</table>

</form>

<font color="red">${message2}</font>
</div>
</div>
</body>
</html>