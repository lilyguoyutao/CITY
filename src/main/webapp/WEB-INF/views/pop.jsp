<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
<script src="artDialog4.1.7/artDialog.js?skin=twitter" type="text/javascript"></script>
<script src="artDialog4.1.7/plugins/iframeTools.js" type="text/javascript"></script>
<script>
function openPage(){ 
	   
	art.dialog.open('login.jsp', {title: '提示'});
	//要传递数据到里一个页面可以通过data来实现 
	
	//打开窗口 
	/*art.dialog.open({
		title:'dialog',
	//	content:'<form action="Footer.jsp" method="post">'+
		'<input type="text" name="cc"/>'+'<input type="submit" value="submit"/>'+'</form>'
	});*/
}
</script>
</head>
<body>
<input type="button" onclick="openPage()" value="ee"/> 
</body>
</html>