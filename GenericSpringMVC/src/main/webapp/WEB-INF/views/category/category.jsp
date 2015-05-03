<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%-- <%@ taglib uri="http://www.springframework.org/tags/form"
    prefix="springForm"%> --%>
<%@ page session="false" %>
<html>
<head>
	<title>Category Page</title>
	<link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
	<link href="<c:url value="/resources/css/product.css" />" rel="stylesheet">
	<style>
	.error {
	    color: #ff0000;
	    font-style: italic;
	    font-weight: bold;
	}
	</style>	
	
	<script src="<c:url value="/resources/js/jquery.min.js" />"></script>
	<script src="<c:url value="/resources/js/person.js" />"></script>
</head>
<body>

<h1>
	Add a category
</h1>

<c:url var="addAction" value="/categories/add" ></c:url>

<form:form action="${addAction}" commandName="category">
<table>
	<c:if test="${!empty category.name}">
	<tr>
		<td>
			<form:label path="id">
				<spring:message text="ID"/>
			</form:label>
		</td>
		<td>
			<form:input path="id" readonly="true" size="8"  disabled="true" />
			<form:hidden path="id" />
		</td> 
	</tr>
	</c:if>
	<tr>
		<td>
			<form:label path="name">
				<spring:message text="Name"/>
			</form:label>
		</td>
		<td>
			<form:input path="name" />
			<form:errors path="*" cssClass="error" element="div" />
			
		</td> 
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty category.name}">
				<input type="submit"
					value="<spring:message text="Edit Product"/>" />
			</c:if>
			<c:if test="${empty category.name}">
				<input type="submit" class="btn btn-success"
					value="<spring:message text="Add Product"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>
<br>
<h3>Category List</h3>
<c:if test="${!empty listCategory}">
	<table class="tg">
	<tr>
		<th width="80">category ID</th>
		<th width="120">category Name</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCategory}" var="category">
		<tr>
			<td>${category.id}</td>
			<td>${category.name}</td>
			<td><a href="<c:url value='/products/edit/${category.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/products/remove/${category.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
