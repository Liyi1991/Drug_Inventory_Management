<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>admin page</title>
<style type="text/css">
body{
	font-family:font-family:Harrington,Helvetica,sans-serif;
	font-size:18px;	
	border-spacing: 800px;
	background-image: url(${pageContext.request.contextPath}/resources/images/subbk.jpg);
	-moz-background-size: cover;
	-webkit-background-size: cover;
	background-size: cover;
	background-position: top center !important;
	background-repeat: no-repeat !important;
	background-attachment: fixed;
}
div#d01 {
	position: fixed; 
	top:50px; 
	left:500px;
}
h1 {
	position: fixed; 
	top:50px; 
	left:280px;
}
label#l01 {
	position: fixed; 
	top:420px; 
	left:190px; 
	font-size: middle; 
	color: teal; 
}
label#l02 {
	position: fixed; 
	top:450px; 
	left:860px; 
	font-size: middle; 
	color: teal;
}
label#l03 {
	position: fixed; 
	top:250px; 
	left:540px; 
	font-size: middle; 
	color: teal;
}
label#l04 {
	position: fixed; 
	top:190px; 
	left:1100px; 
	font-size: middle; 
	color: teal;
}
img#img01 {
	position: fixed; 
	top:450px; 
	left:130px; 
	width:200px;
	height:200px;
}
img#img02 {
	position: fixed; 
	top:480px; 
	left:800px;
	width:200px;
	height:200px; 
}
img#img03 {
	position: fixed; 
	top:280px; 
	left:500px; 
	width:200px;
	height:200px;
}
img#img04 {
	position: fixed; 
	top:220px; 
	left:1020px; 
	width:200px;
	height:200px;
}

</style>
</head>
	<body>
		<a href="passwordChange.html">Change Password?</a><br/>
		<a href="roleChange.html">Change Role?</a>
		<div id="d01">
		   <h1>${userObj.role_id} ${userObj.user_name}, welcome to database management page</h1> 
		</div>	
		<label id="l01">Check-In</label>
		<label id="l02">Check-Out</label>
		<label id="l03">Add-new-Drug</label>
		<label id="l04">Query</label>
		<img src="${pageContext.request.contextPath}/resources/images/checkin.jpg" id="img01" onclick="window.location.href='checkIn.html'"/>		
		<img src="${pageContext.request.contextPath}/resources/images/checkout.jpg" id="img02" onclick="window.location.href='checkOut.htmlt'"/>	 
		<img src="${pageContext.request.contextPath}/resources/images/addnewdrug.jpg" id="img03" onclick="window.location.href='addNewDrug.html'"/>
		<img src="${pageContext.request.contextPath}/resources/images/query.jpg" id="img04" onclick="window.location.href='user.html'"/>		 	  		   	
	</body>
</html>