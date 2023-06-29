<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3 class="my-4">공지글쓰기</h3>
	<form method="post" enctype="multipart/form-data" action="register">
		<table class="tb-row">
			<colgroup>
				<col width="180px">
			</colgroup>
			<tr><th>제목</th>
				<td><input type="text" name="title" class="check-empty form-control" title="제목"></td>
			</tr>
			<tr><th>내용</th>
				<td><textarea name="content" class="check-empty form-control" title="내용"></textarea></td>
			</tr>
			<tr><th>첨부파일</th>
				<td>
					<div class="row">
						<div class="col-auto d-flex align-items-center gap-4">
							<label>
								<input type="file" name="file" class="form-control" id="file-single">
								<i class="fs-3 fa-solid fa-file-circle-plus"></i>
							</label>
							<div class="d-flex gap-3 align-items-center" id="file-attach">
								<span class="file-name"></span>
								<i class="d-none file-delete text-danger fs-3 fa-solid fa-file-circle-xmark"></i>
							</div>
						</div>
					</div>
				</td>
			</tr>
		</table>
		<input type="hidden" name="writer" value="${loginInfo.userid }">
	</form>
	
	<div class="btn-toolbar gap-2 my-3 justify-content-center">
			<button class="btn btn-primary px-4" id="btn-save">저장</button>
			<button class="btn btn-outline-primary px-4" onclick="history.go(-1)">취소</button>
<!-- 			<button class="btn btn-outline-primary" onclick="location='list'">취소</button> -->
	</div>
	
	<script>
	$('#btn-save').click(function(){
		if(emptyCheck()){
			singleFileUpload();
			$('form').submit()
		}
	})
	</script>
	
</body>
</html>