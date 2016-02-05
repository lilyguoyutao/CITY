<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Add community</title>
<script type="text/javascript">


	function OnSave(){
		if(document.Create_form.community_name.value=="")
			{
			  window.alert("please input the project name!");  
			  return false;  
			}
		if(document.Create_form.schoolname.value=="")
		{
		  window.alert("please input the school's name!");  
		  return false;  
		}
		if(document.Create_form.schoolphone.value=="")
		{
		  window.alert("please input the school phone!");  
		  return false;  
		}
		if(document.Create_form.email.value=="")
		{
		  window.alert("please input the Email!");  
		  return false;  
		}
		if(document.Create_form.street.value=="")
		{
		  window.alert("please input the school address!");  
		  return false;  
		}
		if(document.Create_form.city.value=="")
		{
		  window.alert("please input the school address!");  
		  return false;  
		}
		if(document.Create_form.state.value=="")
		{
		  window.alert("please input the school address!");  
		  return false;  
		}
		if(document.Create_form.country.value=="")
		{
		  window.alert("please input the school address!");  
		  return false;  
		}
		
		
		
		return true;
	}
</script>
</head>
<body>
<%@ include file="header.jsp" %>

<jsp:include page="ME.jsp"/>

<div class="nav2">

	<div >
	<table border="0">
		<tr>
			
			<td style="background-color: #ccc;color:yellow;font-family:Arial, Helvetica, sans-serif;font-size:30px;" height="60" width="850">
			&nbsp;&nbsp;Welcome to create community
			</td>
		</tr>
	</table>
			
</div>
<div style="height:10px"></div>

<div style="margin-left:30px">
    
	<form name="Create_form" action="/example/community" method="post">
	<table>
		<tr>
			<td><b>Comunity_name:</b></td>
			<td><input name="community_name" type="text" value="${con.community_name}" /></td>
			<td><input name="check" type="hidden" value="check"/></td>
			<td><b>*Grade:</b></td>
			<th rowspan="2"><select name = "grade" multiple="multiple" size="6">
            	<option value="K">___K___</option>
            	<option value="1">___1___   </option>
            	<option value="2">___2___   </option>
            	<option value="3">___3___   </option>
            	<option value="4">___4___   </option>
            	<option value="5">___5___   </option>
            	<option value="6">___6___   </option>
            	<option value="7">___7___   </option>
            	<option value="8">___8___   </option>
            	<option value="9">___9___   </option>
            	  
            </select></th>
		</tr>
		<tr>
			<td><b>School_name:</b></td>
			<td><input class="fields" name = "schoolname"  value="${con.school_name }"type = "text" size = "15"/></td>
			
		</tr>
		<tr><td><b>School_phone:</b></td>
			<td><input class="fields" name = "schoolphone"  type = "text" size = "15"/></td>
		</tr>
		
		<tr><td><b>Contact_Email:</b></td>
			<td><input class="fields" name = "email"  value="${con.email }"type = "text" size = "15"/></td>
			<td><input name="comccc" type="hidden"/></td>
			<td><input name="comccc" type="hidden"/></td>
			<td><input name="comccc" type="hidden"/></td>
			
			<td></td>
		    
		</tr>
		
		
		<tr><td><input name="comccc" type="hidden"/></td></tr>
		
		<tr>
		<td><b>School Address:</b></td>
		
		</tr>
		<tr>
			<td>Street</td>
			<td><input class="fields" name = "street"  type = "text" size = "15"/></td>
			<td>City</td>
			<td><input class="fields" name = "city"  type = "text" size = "15"/></td>
			

		</tr>
		
		<tr>
		<td>State/province</td>
			<td><input class="fields" name = "state"  type = "text" size = "15"/></td>
			<td>Country</td>
			<td><input class="fields" name = "country"  type = "text" size = "15"/></td>
		</tr>
		
		<tr>
			<td></td>
			<td colspan="3"></td>
		</tr>
	</table>
	<br>
	<br>
	<center>&nbsp;&nbsp;&nbsp;<input name="save" type="submit" id="create_save" value= "Save" onclick="return OnSave();"/>&nbsp;&nbsp;&nbsp;<input name="save" type="reset" id="create_save" value= "Cancel" />&nbsp;&nbsp;&nbsp;
	<a style="font-size: 20px" href="/example/detail?comm_name=${con.community_name}"><img src="resources/Add.png" style="width:30px; height:30px;"></a></center>
     </form>
     <p>${ message }</p>
</div>
</div>
</body>
</html>