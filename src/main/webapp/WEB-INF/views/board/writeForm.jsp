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

	<form action="/board/write" method="POST">

		<table>
			<tr>
				<th>제목</th>
				<th><input type="text" name="title"></th>
			</tr>

			<tr>
				<td colspan="2"><b>내용</b></td>
			</tr>

			<tr>
				<td colspan="2"><textarea rows="8" cols="40" name="content"></textarea></td>
			</tr>
		</table>
		<input type="submit" value="완료">

	</form>

</body>
</html>