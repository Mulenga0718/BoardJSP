<%@page import="com.sun.glass.ui.Application"%>
<%@page import="com.jsp.vo.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>회원리스트</h2>
<hr>
<p style="text-align: left"><input type="button" value="회원가입" onclick="location.href='regist'"></p>
<table border="1">
	<tr>
		<td>번호</td>
		<td>아이디</td>
		<td>비밀번호</td>
		<td>상세보기</td>
		<td>수정</td>
		<td>삭제</td>
	</tr>
	<% 
	 List<Member> list = (List<Member>)request.getAttribute("memberList");
		for(int i = 0; i<list.size(); i++){
			application.setAttribute("list", list.get(i)); 
			application.setAttribute("num", i+1); 
	%>	
	 <tr>
		<td>${num }</td>
		<td>${list.id }</td>
		<td>${list.pwd }</td>
		<td><a href="detail?id=${list.id }">상세보기</a></td>
		<td><input type ="button" value="수정" onclick="location.href='modify?id=${list.id }'"></td>
		<td><input type ="button" value="삭제" onclick="location.href='delete?id=${list.id}'"></td>
	</tr>
			
		
	<%	
		}
	%>
	
</table>
</body>
</html>