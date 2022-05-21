<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<form action="modify?num=${vo.num}" method="post">
<p>제목 :  <input type = text name="title"> </p>
<p class="right">작성자: ${vo.writer } </p>
<p class="right">작성일: ${vo.date }  </p>
<h5>수정 내용</h5>
<textarea rows="6" cols="70" name="content" style="resize: none"></textarea><br>
<p style="text-align: right; padding-right: 50px">
	<input type="submit" value="수정" class="btn btn-success">
	<input type="button" class="btn btn-warning" value="목록" onclick="location.href='list'">
</p>
</form>
</div>

</body>
</html>