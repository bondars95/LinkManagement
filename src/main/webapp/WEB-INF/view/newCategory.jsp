<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>All Categories List</title>
<style>.error{color:red; font-weight:bold;}</style>
</head>
<body>
	<div id="mvc">
		<h1>All Categories List</h1>
		<table>
			<tr>
				<th>Name</th>
				<c:forEach var="category" items="${categoryList}">
					<tr>
						<td><c:out value="${category.name}" /></td>
					</tr>
				</c:forEach>
		</table>
		<cf:form method="POST" action="addCategory" modelAttribute="category">
			<br />
			<table>
				<tr>
					<td><cf:label path="name">Name</cf:label></td>
					<td><cf:input path="name" /> <input type="submit"
						value="Add category" /> <br /> <cf:errors path="name"
							cssClass="error" /></td>
				</tr>
			</table>
		</cf:form>
	</div>
</body>
</html>
