<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>warehouse information page</title>
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
	left:650px;
}
div {
	position: fixed; 
	top:120px; 
	left:450px;
}
</style>
</head>
<body>
<center> 
   <div>
        <table border="3pt ridge lightgrey" cellpadding="1">
            <caption >Warehouse Information List</caption>
            <tr>
                <td>Warehouse_ID</td>
                <td>Street</td>
                <td>City</td>
                <td>State</td>
                <td>Zip_Code</td>
                <td>Phone</td>
            </tr>
         <c:if test="${not empty warehouseList}">
            <c:forEach var="listValue" items="${warehouseList}">
                <tr>
                    <td><c:out value="${listValue.warehouse_id}"/></td>
                    <td><c:out value="${listValue.street}"/></td>
                    <td><c:out value="${listValue.city}"/></td>
                    <td><c:out value="${listValue.state}"/></td>
                    <td><c:out value="${listValue.zip_code}"/></td>
                    <td><c:out value="${listValue.phone}"/></td>
            </c:forEach>
         </c:if>
        </table>
    </div> 
</center>    
</body>
</html>