<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>add new drug page</title>
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
	top:470px; 
	left:218px; 
}
</style>
</head>
<body>
<a href="admin.html">Back to MainPage</a>
<center> 
	<div>
	    <h4 id="h01">New-Drug-Adding Input</h4> 
	</div>
  	<div>
   	<form:form method="post" action="process-addNewDrug.html" modelAttribute ="drug">
    <table id="t01">
     	<tr>
      		<td> Generic Name :</td>
      		<td><form:input path="generic_name" /></td>
     	</tr>
     	<tr>
      		<td> Brand Name :</td>
      		<td><form:input path="brand_name" /></td>
     	</tr>
     	<tr>
      		<td> Dosage Form :</td>
      		<td><form:input path="dosage_form" /></td>
     	</tr>
     	<tr>
      		<td> Manufacturer :</td>
      		<td><form:input path="manufacturer" /></td>
     	</tr>
     	<tr>
      		<td> Expiration Date :</td>
      		<td><form:input path="expiration" value="${Today}"/></td>
     	</tr>
     	<tr>
      		<td> Upper Bound :</td>
      		<td><form:input path="upperbound" /></td>
     	</tr>
     	<tr>
      		<td> Lower Bound :</td>
      		<td><form:input path="lowerbound" /></td>
     	</tr>
     	<tr>
      		<td><input id="in01" type="submit" value="Add-New-Drug"/></td>
     	</tr>     
    </table>
    </form:form>  
  </div>
 </center>
   <div id="d02">
        <table border="3pt ridge lightgrey" cellpadding="1">
            <caption >New Drug Adding Result</caption>
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
         <c:if test="${not empty newestDrug}">
            
                <tr>
                    <td><c:out value="${newestDrug.drug_id}"/></td>
                    <td><c:out value="${newestDrug.generic_name}"/></td>
                    <td><c:out value="${newestDrug.brand_name}"/></td>
                    <td><c:out value="${newestDrug.dosage_form}"/></td>
                    <td><c:out value="${newestDrug.manufacturer}"/></td>
                    <td><c:out value="${newestDrug.expiration}"/></td>
                    <td><c:out value="${newestDrug.upperbound}"/></td>
                    <td><c:out value="${newestDrug.lowerbound}"/></td>                   
                </tr>
       
         </c:if>
        </table>
    </div>     
</body>
</html>