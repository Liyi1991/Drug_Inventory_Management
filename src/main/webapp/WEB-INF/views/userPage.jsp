<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>user page</title>
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
	left:350px;
}
label#l01 {
	position: fixed; 
	top:168px; 
	left:235px; 
	font-size: middle; 
	color: teal; 
}
label#l02 {
	position: fixed; 
	top:420px; 
	left:630px; 
	font-size: middle; 
	color: teal;
}
label#l03 {
	position: fixed; 
	top:148px; 
	left:1180px; 
	font-size: middle; 
	color: teal;
}
img#img01 {
	position: fixed; 
	top:200px; 
	left:200px; 
	width:200px;
	height:200px;
}
img#img02 {
	position: fixed; 
	top:450px; 
	left:600px;
	width:200px;
	height:200px; 
}
img#img03 {
	position: fixed; 
	top:180px; 
	left:1150px; 
	width:200px;
	height:200px;
}

</style>
</head>
	<body>
	<a href="passwordChange.html">Change Password?</a><br/>
	<a href="expiredDrugs.html">${expiredDrugsLength} drugs expired!!!</a><br/>
	<a href="drugsOutOfBounds.html">${outOfBoundsDrugsLength} drugs out of bounds!!!</a><br/>
	<a href="warehouseInfo.html"> Checking warehouse information?</a><br/>
		<div id="d01">
		   <h1>${userObj.role_id} ${userObj.user_name}, welcome to database query page</h1> 
		</div>	
		<label id="l01">Query-for-Drug</label>
		<label id="l02">Query-for-Inventory</label>
		<label id="l03">Query-for-History</label>
		<img src="${pageContext.request.contextPath}/resources/images/drug.jpg" id="img01" onclick="window.location.href='queryForDrug.html'"/>		
		<img src="${pageContext.request.contextPath}/resources/images/inventory.jpg" id="img02" onclick="window.location.href='queryForInventory.html'"/>	 
		<img src="${pageContext.request.contextPath}/resources/images/history.jpg" id="img03" onclick="window.location.href='queryForHistory.html'"/>	 	  		   	
	</body>
</html>