<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="/user/join" method="POST" >
	<table>
	
		<tr>
			<td>username</td>
			<td><input type="text" name="username"></td>
		</tr>
		
		<tr>
			<td>password</td>
			<td><input type="password" name="password"></td>
		</tr>
		
		<tr>
			<td>email</td>
			<td><input type="email" name="email"></td>
		</tr>
		
		<tr>
			<td>phone</td>
			<td><input type="text" name="phone"></td>
		</tr>
		
		<tr>
			<td colspan="2"><input type="submit" value="가입완료"></td>
			
		</tr>		
	
	</table>
</form>
</body>
</html>