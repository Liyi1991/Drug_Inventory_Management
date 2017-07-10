<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>query for drug page</title>
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
	top:250px; 
	left:80px;
}
caption {
	position: fixed; 
	top:80px; 
	left:820px;
}
table#t01 {
 	position: fixed; 
 	top:320px; 
 	left:10px;
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
	top:380px; 
	left:169px; 
}
</style>
</head>
<body>
<a href="user.html">Back to MainPage</a>
<center> 
	<div>
	    <h4 id="h01">Drug Query Input</h4> 
	</div>
  <div id="d01">
   <form method="post" action="queryForDrug.html" >
    <table id="t01">
     <tr>
      <td> Generic Name :</td>
	  <td><input name="generic_name" type="text"/></td>
     </tr>
     <tr>
      <td> Manufacturer :</td>
	  <td><input name="manufacturer"  type="text"/></td>
     </tr>
     <tr>
      <td><input id="in01" type="submit" value="Query-on-Drug"/></td>
     </tr>     
    </table>
    </form>
  </div>
 </center>
   <div id="d02">
        <table border="3pt ridge lightgrey" cellpadding="1">
            <caption >Drug Query Result</caption>
            <tr>
                <td>Drug_ID</td>
                <td>Generic_Name</td>
                <td>Brand_Name</td>
                <td>Dosage_Form</td>
                <td>Manufacturer</td>
                <td>Expiration Date</td>
                <td>Upper Bound</td>
                <td>Lower Bound</td>
            </tr>
         <c:if test="${not empty drugList}">
            <c:forEach var="listValue" items="${drugList}">
                <tr>
                    <td><c:out value="${listValue.drug_id}"/></td>
                    <td><c:out value="${listValue.generic_name}"/></td>
                    <td><c:out value="${listValue.brand_name}"/></td>
                    <td><c:out value="${listValue.dosage_form}"/></td>
                    <td><c:out value="${listValue.manufacturer}"/></td>
                    <td><c:out value="${listValue.expiration}"/></td>
                    <td><c:out value="${listValue.upperbound}"/></td>
                    <td><c:out value="${listValue.lowerbound}"/></td>                   
                </tr>
            </c:forEach>
         </c:if>
        </table>
    </div>     
</body>
</html>