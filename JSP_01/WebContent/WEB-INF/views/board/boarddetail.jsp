<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  <link rel="stylesheet" href="<%=request.getContextPath() %>/resources/bootstrap/dist/css/adminlte.min.css">
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<style>
#outter{
	border: solid 1px gray;
	width: 600px;
	margin: auto;
	padding: 20px;
}

</style>

</head>
<body>
<h2 style="text-align: center">게시글 조회</h2>
<hr>
<br>
<div id="outter">
<p>제목 : ${boardvo.title }</p>
<p class="right">작성자: ${boardvo.writer } </p>
<p class="right">작성일: <fmt:formatDate value="${boardvo.regDate }" pattern="yyyy-MM-dd"/></p>
<h5>내용</h5>
<textarea rows="6" cols="70" name="content" style="resize: none" readonly>${boardvo.content } </textarea><br>
<p style="text-align: right; padding-right: 50px">
	<input type="button" value="수정" class="btn btn-success"onclick = "location.href='modify?bno=${boardvo.bno }'">
<input type="button" value="삭제" class="btn btn-danger" onclick = "location.href='delete?bno=${boardvo.bno }'">
	<input type="button" class="btn btn-warning" value="목록" onclick="location.href='list'">
</p>

</div>
</body>
</html>