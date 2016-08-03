<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="cf"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="/resources/css/style.css" />"
	rel="stylesheet">
<title>Link List</title>

</head>
<body>
	<div id="mvc">
		<br />
		<table>
			<tr>
				<td><cf:form method="POST" action="findByDesc"
						modelAttribute="link">
						<input type="text" name="findByWord" />
						<input type="submit" value="Find by context" />
					</cf:form></td>
				<td><form method="POST" action="findByCategory">
						<select size="1" name="categoryChoice">
							<c:forEach var="category" items="${categoryList}">
								<option value="${category.name}"><c:out
										value="${category.name}" /></option>
							</c:forEach>
						</select> <input type="submit" value="Find by category" />
					</form>
				<td colspan=2>
					<form method="POST" action="findByLanguage">
						<select size="1" name="language">
							<option disabled>Choose language</option>
							<option value="UA">UA</option>
							<option value="RU">RU</option>
							<option value="EN">EN</option>
							<option value="FR">FR</option>
						</select> <input type="submit" value="Find by lang" />
					</form>
				</td>
			</tr>
			<tr>
				<td>
					<form method="POST" action="findByIsFinished">
						<select size="1" name="isFinished">
							<option disabled>Choose status</option>
							<option value="N">N</option>
							<option value="Y">Y</option>
						</select> <input type="submit" value="Find by read status" />
					</form>
				</td>
				<td>
					<form method="POST" action="orderBy">
						<select size="1" name="orderBySmth">
							<option disabled>Choose field</option>
							<option value="name">Name</option>
							<option value="created">Date</option>
						</select> <select size="1" name="orderDirect">
							<option disabled>Choose type</option>
							<option value="ASC">ASC</option>
							<option value="DESC">DESC</option>
						</select> <input type="submit" value="Order" />
					</form>
				</td>

				<td><form method="POST" action="orderByDate">
						from:
						<script type="text/javascript"
							src="http://www.snaphost.com/jquery/Calendar.aspx?dateFormat=yy-mm-dd">"> </script>
						</br>
						&nbsp; to: <script type="text/javascript"   >
						$(function() {
							$("#SnapHost_Calendar2")
									.datepicker(
											{
												showOn : 'both',
												buttonImage : 'http://www.snaphost.com/jquery/calendar.gif',
												buttonImageOnly : true,
												changeMonth : true,
												showOtherMonths : true,
												selectOtherMonths : true,
												dateFormat: 'yy-mm-dd'
											});
						});
					</script> <input name="SnapHost_Calendar2" id="SnapHost_Calendar2"
					type="text" 	/> 
						 <input type="submit" value="Find" />
					</form></td>


			</tr>
		</table>

		<br />
		<table>
			<tr>
				<th>Id</th>
				<th>Name(URL)</th>
				<th>Description</th>
				<th>Date of creation</th>
				<th>Language</th>
				<th>IsFinished</th>
				<th>Categories</th>
			</tr>
			<c:forEach var="link" items="${linkList}">
				<tr>

					<td><c:out value="${link.id}" /></td>
					<td><a href="<c:out value="${link.address}" />"> <c:out
								value="${link.name}" /></a></td>
					<td><c:out value="${link.description}" /></td>
					<td><c:out value="${link.created}" /></td>
					<td><c:out value="${link.lang}" /></td>
					<td><c:out value="${link.finish}" /></td>
					<td><c:forEach var="category" items="${link.categories}">
							<c:out value="${category.name}" />,
					</c:forEach></td>
					<td><a href="${link.id}" title="Edit"> <img alt="Edit"
							border="0" src="<c:url value="/resorsec/images/edit.ico" />"
							width="16" height="16">
					</a></td>
					<td><a href="delete${link.id}" title="Delete"> <img
							alt="Edit" border="0"
							src="<c:url value="/resources/images/delete.ico" />"
							width="16" height="16">
					</a></td>

				</tr>
			</c:forEach>
		</table>

	</div>
</body>
</html>
