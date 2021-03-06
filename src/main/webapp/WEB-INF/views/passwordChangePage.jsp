<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>password change page</title>
<style type="text/css">
body{
	font-family:font-family:Harrington,Helvetica,sans-serif;
	font-size:18px;	
	border-spacing: 800px;
	background-image: url(${pageContext.request.contextPath}/resources/images/bk.jpg);
	-moz-background-size: cover;
	-webkit-background-size: cover;
	background-size: cover;
	background-position: top center !important;
	background-repeat: no-repeat !important;
	background-attachment: fixed;	
}
h1 {
	position: fixed; 
	top:50px; 
	left:500px;
}
h3#h01 {
 	position: fixed; 
 	top:260px; 
 	left:1100px;
}
h3#h02 {
	position: fixed; 
	top: 420px; 
	left: 1163px;
}
table {
 	position: fixed; 
 	top:330px; 
 	left:1100px;
}
input {
	font-size: middle; 
	color: teal; 
	background-color: #FFFFC0; 
	border: 3pt ridge lightgrey;
}
button {
	font-size: middle; 
	color: teal; 
	background-color: #FFFFC0; 
	border: 3pt ridge lightgrey;
}
input#in01 {
	position: fixed; 
	top:390px; 
	left: 1215px;
}
</style>
</head>
<body>
<center> 
	<div>
	    <h1>Welcome to password change page</h1> 
	</div>
  	<div>
   	<form:form method="post" action="process-passwordChange.html" modelAttribute="user">
   	<h3 id="h01">Change password here:</h3>
    <table>
     	<tr>
      		<td> UserName :</td>
      		<td><form:input path="user_name" value="${userObj.user_name}"/></td>
     	</tr>
    	<tr>
      		<td> Password :</td>
      		<td><form:input path="password" type = "password"/></td>
     	</tr>
     	<tr>
      		<td><input id="in01" type="submit" value="Change-Password"/></td>
     	</tr>     
    </table>
    </form:form> 
  </div>
 </center>
</body>
</html>
