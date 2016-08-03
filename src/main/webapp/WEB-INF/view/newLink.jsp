<%@ page language="java" contentType="text/html; 	charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01   
       Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; 		charset=UTF-8">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet"
	type="text/css">
<title>New LInk</title>
<style>
.error {
	color: red;
	font-weight: bold;
}
</style>
</head>
<body>
	<h1>Link Information</h1>
	<cf:form method="POST" action="addLink" modelAttribute="link">
		<cf:hidden path="id" />
		<cf:hidden path="created" />
		<table>
			<tr>
				<td><cf:label path="address">Address</cf:label></td>
				<td><cf:input path="address" /> <br /> <cf:errors
						path="address" cssClass="error" /></td>
			</tr>
			<tr>
				<td><cf:label path="name">Name</cf:label></td>
				<td><cf:input path="name" /><br /> <cf:errors path="name"
						cssClass="error" /></td>
			</tr>
			<tr>
				<td><cf:label path="description">Description</cf:label></td>
				<td><cf:textarea path="description" maxlengh="200" rows="4"
						cols="25" /></td>
			</tr>
			<tr>
				<td><cf:label path="lang">Language</cf:label></td>
				<td><cf:select size="1" name="language" path="lang">
						<cf:option value="UA">UA</cf:option>
						<cf:option value="RU">RU</cf:option>
						<cf:option value="EN">EN</cf:option>
						<cf:option value="FR">FR</cf:option>
					</cf:select> <cf:errors path="lang" cssClass="error" /></td>
			</tr>

			<tr>
				<td><cf:label path="finish">IsFinished</cf:label></td>
				<td><cf:radiobutton path="finish" value="Y" label="Y" /> <cf:radiobutton
						path="finish" value="N" label="N" /><br /> <cf:errors
						path="finish" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label>Category</label></td>
				<td><select multiple size="6" name="categoryChoice">
						<c:if test="${currentCategories==null}">
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.name}"><c:out
										value="${category.name}" /></option>
							</c:forEach>
						</c:if>

						<c:if test="${currentCategories!=null}">

							<c:forEach var="currentCategory" items="${currentCategories}">
								<c:forEach var="category" items="${categoryList}">
									<c:choose>
										<c:when test="${category.name==currentCategory.name }">
											<option selected value="${category.name}"><c:out
													value="${category.name}" /></option>
										</c:when>
									</c:choose>
								</c:forEach>
							</c:forEach>
							<c:forEach var="currentCategory" items="${currentCategories}">
								<c:forEach var="category" items="${categoryList}">
									<c:choose>
										<c:when test="${category.name!=currentCategory.name }">
											<option value="${category.name}"><c:out
													value="${category.name}" /></option>
										</c:when>
									</c:choose>
								</c:forEach>
							</c:forEach>
						</c:if>
				</select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</cf:form>
</body>
</html>

