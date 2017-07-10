<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>expired drugs list page</title>
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
	left:640px;
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
            <caption >Expired Drugs List</caption>
            <tr>
                <td>Drug_ID</td>
                <td>Generic_Name</td>
                <td>Expiration_Date</td>
                <td>Warehouse_ID</td>
                <td>Quantity</td>
            </tr>
         <c:if test="${not empty drug_warehouseList}">
            <c:forEach var="listValue" items="${drug_warehouseList}">
                <tr>
                    <td><c:out value="${listValue.drug.drug_id}"/></td>
                    <td><c:out value="${listValue.drug.generic_name}"/></td>
                    <td><c:out value="${listValue.drug.expiration}"/></td>
                    <td><c:out value="${listValue.warehouse.warehouse_id}"/></td>
                    <td><c:out value="${listValue.quantity}"/></td>
            </c:forEach>
         </c:if>
        </table>
    </div> 
</center>    
</body>
</html>