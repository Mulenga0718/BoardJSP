<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action = "modify" method="post">
	<table border="1">
		<tr>
			<td>아이디</td>
			<td><input type="text" value="${member.id}" name ="id">
			<input type="hidden" value="${member.id}" name ="oldid">
			</td>
			
		</tr>
		<tr>
			<td>비밀번호</td>
			<td><input type="text" value="${member.pwd}" name ="pwd"></td>
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="수정"></td>
		</tr>
	</table>
</form>
</body>
</html>