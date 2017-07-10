<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>role change page</title>
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
caption {
	position: fixed; 
	top:80px; 
	left:290px;
}
div#d01 {
	position: fixed; 
	top:120px; 
	left:230px;
}
div#d02 {
	position: fixed; 
	top:60px; 
	left:630px;
}
input {
	font-size: middle; 
	color: teal; 
	background-color: #FFFFC0; 
	border: 3pt ridge lightgrey;
}
input#in01 {
	position: fixed;
	top:185px;
	left:776px;
}
</style>
</head>
<body>
<a href="admin.html">Back to MainPage</a>
<center> 
   <div id="d01">
        <table border="3pt ridge lightgrey" cellpadding="1">
            <caption >Role Information List</caption>
            <tr>
            	<td>User_Name</td>
            	<td>Role_ID</td>                
                <td>Role_Name</td>
            </tr>
         <c:if test="${not empty userRoleList}">
            <c:forEach var="listValue" items="${userRoleList}">
                <tr>
                    <td><c:out value="${listValue.user_name}"/></td>
                    <td><c:out value="${listValue.role_id}"/></td>                    
                    <td><c:out value="${listValue.role_name}"/></td>
            </c:forEach>
         </c:if>
        </table>
       </div>
  	<div id="d02">
   	<form:form method="post" action="process-roleChange.html" modelAttribute="user">
   	<h3>Change role here:</h3>
    <table>
     	<tr>
      		<td> User Name :</td>
      		<td><form:input path="user_name" /></td>
     	</tr>
    	<tr>
      		<td> Role ID :</td>
      		<td><form:input path="role_id"/></td>
     	</tr>
     	<tr>
      		<td><input id="in01" type="submit" value="Change-Role"/></td>
     	</tr>     
    </table>
    </form:form> 
  </div>
</center>    
</body>
</html>