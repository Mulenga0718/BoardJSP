<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">

<script
	src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>




<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/summernote-lite.js"></script>
<script src="<%=request.getContextPath() %>/resources/js/lang/summernote-ko-KR.js"></script>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resources/css/summernote-lite.css">
<style type="text/css">

#outter{
	border: solid 1px gray;
	width: 600px;
	margin: auto;
	padding: 20px;
}
</style>
<script type="text/javascript">
$(document).ready(function() {
	//여기 아래 부분
	$('#summernote').summernote({
		  height: 300,                 // 에디터 높이
		  minHeight: null,             // 최소 높이
		  maxHeight: null,             // 최대 높이
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다'	//placeholder 설정
          
	});
});
</script>
</head>
<body>
<h2 style="text-align: center">게시글 등록</h2>
<hr>
<br>
<div id="outter">
<form action="<%=request.getContextPath()%>/board/regist" method="post">
<label>제목</label>
<input type ="text" name ="title" class="form-control" style="width: 500px; heigth:30px;"><br>
<label>내용</label><br>
<textarea rows="6" cols="70" name="content" style="resize: none" id="summernote"></textarea><br>
<p style="text-align: right; padding-right: 50px">
	<input type="submit" class="btn btn-primary">
	<input type="button" class="btn btn-warning" value="목록" onclick="location.href='list'">
</p>

</form>
</div>
</body>

</html>