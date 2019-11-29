<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="/admin/update" method="POST">
		<input type="hidden" value="${user.id }" name="id">
		<input type="hidden" value="${user.password }" name="password">
		<input type="hidden" value="${user.phone }" name="phone">
		<input type="hidden" value="${user.email }" name="email">
		<input type="text" name="username" value="${user.username}" readonly="readonly"><br>


		<c:choose>
			<c:when test="${user.role eq 'admin'}">
				<select name="role">
					<option value="user">user</option>
					<option value="admin" selected="selected">admin</option>
				</select>
				<br>
			</c:when>
			<c:otherwise>
				<select name="role">
					<option value="user" selected="selected">user</option>
					<option value="admin">admin</option>
				</select>
				<br>

			</c:otherwise>
		</c:choose>
		<input type="submit" value="변경">
	</form>

</body>
</html>