<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>check in page</title>
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
h4#h01 {
	position: fixed; 
	top:200px; 
	left:100px;
}
caption {
	position: fixed; 
	top:80px; 
	left:750px;
}
table#t01 {
 	position: fixed; 
 	top:270px; 
 	left:50px;
}
input {
	font-size: middle; 
	color: teal; 
	background-color: #FFFFC0; 
	border: 3pt ridge lightgrey;
}
div#d01 {
	position: fixed; 
	top:130px; 
	left:510px;
}
div#d02 {
	position: fixed; 
	top:120px; 
	left:450px;
}
input#in01 {
	position: fixed; 
	top:415px; 
	left:227px; 
}
</style>
</head>
<body>
<a href="admin.html">Back to MainPage</a>
<center> 
	<div>
	    <h4 id="h01">Checking-In Input</h4> 
	</div>
  	<div>
   	<form:form method="post" action="process-checkIn.html" modelAttribute="checking_history">
    <table id="t01">
     	<tr>
      		<td> Drug ID :</td>
      		<td><form:input path="drug_id" /></td>
     	</tr>
     	<tr>
      		<td> Warehouse ID :</td>
      		<td><form:input path="warehouse_id" /></td>
     	</tr>
     	<tr>
      		<td> User Name :</td>
      		<td><form:input path="user_name" value="${userObj.user_name}"/></td>
     	</tr>
     	<tr>
      		<td> Quantity :</td>
      		<td><form:input path="quantity" /></td>
     	</tr>
     	<tr>
      		<td> Checking Date :</td>
      		<td><form:input path="checking_date" value="${Today}"/></td>
     	</tr>
     	<tr>
      		<td><input id="in01" type="submit" value="Checking-In"/></td>
     	</tr>     
    </table>
    </form:form>  
  </div>
 </center>
   <div id="d02">
        <table border="3pt ridge lightgrey" cellpadding="1">
            <caption>Checking_In Result</caption>
            <tr>
                <td>Checking_ID</td>
                <td>Drug_ID</td>
                <td>Warehouse_ID</td>
                <td>User_Name</td>
                <td>Quantity</td>
                <td>Checking_Date</td>
                <td>If_Checked_In</td>
            </tr>
          <c:if test="${not empty newestChecking_history}">
           
                <tr>
                    <td><c:out value="${newestChecking_history.checking_id}"/></td>
                    <td><c:out value="${newestChecking_history.drug_id}"/></td>
                    <td><c:out value="${newestChecking_history.warehouse_id}"/></td>
                    <td><c:out value="${newestChecking_history.user_name}"/></td>
                    <td><c:out value="${newestChecking_history.quantity}"/></td>
                    <td><c:out value="${newestChecking_history.checking_date}"/></td>
                    <td><c:out value="${newestChecking_history.if_checked_in}"/></td>                  
                </tr>
           
         </c:if>
        </table>
    </div>     
</body>
</html>