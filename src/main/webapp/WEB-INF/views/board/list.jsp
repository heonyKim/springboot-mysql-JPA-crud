<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>

	<table border="1">
	<tr>
		<th>번호</th>
		<th>제목</th>
		<th>작성자</th>
		<th>작성시간</th>>
	</tr>
	
	<c:forEach var="board" items="${boards}">
		<tr>
			<td>${board.id }</td>
			<td><a href="/board/detail/${board.id }">${board.title }</a></td>
			<td>${board.user.username}</td>
			<td>${board.createDate }
		</tr>
	</c:forEach>
	</table>
	<a href="/board/writeForm">쓰기</a>
	
</body>
</html>