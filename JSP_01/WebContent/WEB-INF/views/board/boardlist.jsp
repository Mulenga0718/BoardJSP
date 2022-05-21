<%@page import="com.jsp.command.PageMaker"%>
<%@page import="com.jsp.vo.BoardVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
	src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<script
	src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>

</head>
<body>

	<div class="card">
		<div class="card-header">
			<h2 style="text-align: center">게시판</h2>
		<div style="text-align: right">
			<input type="button" class="btn btn-primary" value="새글 작성"
				onclick="location.href='regist'" style="width: 150px; margin: 20px">
		<div id="keyword" class="card-tools" style="width: 550px; text-align: right">
				<div class="input-group row">
					<!-- search bar -->
					<!-- sort num -->
					<select class="form-control col-md-3" name="perPageNum"
						id="perPageNum" onchange="list_go(1)">
						<c:set var="perpagenum" value="${pageMaker.getCri().getPerPageNum()}"/>
						<option value="10" ${perpagenum ==10? "selected" : "" } >정렬개수</option>
						<option value="2" ${perpagenum ==2? "selected" : "" }>2개씩</option>
						<option value="3" ${perpagenum ==3? "selected" : "" }>3개씩</option>
						<option value="5" ${perpagenum ==5? "selected" : "" }>5개씩</option>
					</select>

					<!-- search bar -->
					<select class="form-control col-md-3" name="searchType"
						id="searchType">
						<option value="">검색구분</option>
						<option value="i" ${param.searchType =='i'?"selected":"" }>아이디</option>
						<option value="n" ${param.searchType =='n'?"selected":"" }>이 름</option>
						<option value="p" ${param.searchType =='p'?"selected":"" }>전화번호</option>
			 			<option value="e" ${param.searchType =='e'?"selected":"" }>이메일</option>
					</select>
					<!-- keyword -->
					<input class="form-control" type="text" name="keyword"
						placeholder="검색어를 입력하세요." value="" /> <span
						class="input-group-append">
						<button class="btn btn-primary" type="button" id="searchBtn"
							data-card-widget="search" onclick="list_go(-1)">
							<i class="fa fa-fw fa-search"></i>
						</button>
					</span>
					<!-- end : search bar -->
				</div>
			</div>
		</div>
		</div>
		<div class="card-body">
			<div id="example2_wrapper" class="dataTables_wrapper dt-bootstrap4">
				<div class="row">
					<div class="col-sm-12 col-md-6"></div>
					<div class="col-sm-12 col-md-6"></div>
				</div>
				<div class="row">
					<div class="col-sm-12">
						<table id="example2"
							class="table table-bordered table-hover dataTable dtr-inline"
							role="grid" aria-describedby="example2_info">
							<thead>
								<tr role="row">
									<th style="text-align: center; width: 200px"
										class="sorting sorting_asc" tabindex="0"
										aria-controls="example2" rowspan="1" colspan="1"
										aria-sort="ascending"
										aria-label="Rendering engine: activate to sort column descending">번호</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Browser: activate to sort column ascending">제목</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Platform(s): activate to sort column ascending"
										style="text-align: center; width: 200px">작성자</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="Engine version: activate to sort column ascending"
										style="text-align: center; width: 200px">작성일</th>
									<th class="sorting" tabindex="0" aria-controls="example2"
										rowspan="1" colspan="1"
										aria-label="CSS grade: activate to sort column ascending"
										style="text-align: center; width: 200px">조회수</th>
								</tr>
							</thead>
							<tbody>
							<c:set var ="number" value="${true}" />
								<c:choose>
								<c:when test="${not empty boardList }">
								
								<c:forEach items="${boardList}"  var ="boardlist">

								<tr>
								</tr>
								<c:if test="${number eq true }">
								<tr class="odd">
								</c:if>
								<c:if test="${number eq false }">
								<tr class="even">
								</c:if>
								
									<td class="dtr-control sorting_1" tabindex="0"
										style="text-align: center">${boardlist.bno }</td>
									<td onclick="location.href='detail?bno=${boardlist.bno }'"
										style="cursor: pointer">${boardlist.title }</td>
									<td style="text-align: center">${boardlist.writer}</td>
									<td style="text-align: center"><fmt:formatDate
											value="${boardlist.regDate }" pattern="yyyy-MM-dd" /></td>
									<td style="text-align: center">${boardlist.viewCnt }</td>
								</tr>
								<c:set var ="number" value="${!number }" />
								</c:forEach>
								</c:when>
								<c:otherwise>
									<tr>
							<td colspan='7' class="text-center">해당내용이 없습니다.</td>
									</tr>
							</c:otherwise>
								</c:choose>
							
							</tbody>
							<tfoot>
								<tr></tr>
							</tfoot>
						</table>
					</div>
				</div>
				<div class="row">
					<div class="col-sm-12 col-md-5">
						<div class="dataTables_info" id="example2_info" role="status"
							aria-live="polite"></div>
</div>
<div class="col-sm-12 col-md-7">
	<div class="dataTables_paginate paging_simple_numbers"
		id="example2_paginate">
		<ul class="pagination">
			<li class="paginate_button page-item previous"
				id="example2_previous"><a href="javascript:list_go(1)"
				aria-controls="example2" data-dt-idx="0" tabindex="0"
				class="page-link">Previous</a></li>
				<c:set var="startPage" value= "${pageMaker.getStartPage() }"/>
					<c:set var="endPage" value= "${pageMaker.getEndPage() }"/>
					<c:set var="pageNum" value= "${pageMaker.getCri().getPage() }"/>
				<c:forEach var="i" begin="${startPage }" end="${endPage }" step="1" varStatus="status">
					
					<li class="page-item ${i==pageNum?"active":""}"><a class="page-link" href="javascript:list_go(${ i })">
							${ i } </a></li>
					</c:forEach>
					
			<li class="paginate_button page-item next" id="example2_next"><a
				href="#" aria-controls="example2" data-dt-idx="7" tabindex="0"
				class="page-link">Next</a></li>
		</ul>
	</div>
</div>
				</div>
			</div>
		</div>

	</div>
	
	<form id ="jobForm">
	<input type="hidden" name="page" value="">
	<input type="hidden" name="perPageNum" value="">
	<input type="hidden" name="searchType" value="">
	<input type="hidden" name="keyword" value="">
	</form>
		<script>
		function list_go(page,url){
			//alert(page);
			if(!url) url="list";
			
			var jobForm=$('#jobForm');
			jobForm.find("[name='page']").val(page);
			jobForm.find("[name='perPageNum']").val($('select[name="perPageNum"]').val());
			jobForm.find("[name='searchType']").val($('select[name="searchType"]').val())
			jobForm.find("[name='keyword']").val($('div.input-group>input[name="keyword"]').val())
			jobForm.attr({
				action:url,
				method:'get'
			}).submit();
			
		}	
		</script>
</body>
</html>