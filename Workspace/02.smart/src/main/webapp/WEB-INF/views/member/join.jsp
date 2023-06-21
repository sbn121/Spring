<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table th span {
	margin-right: 10px;
	color: rgb(220, 53, 69);
}
</style>
</head>
<body>
	<h3 class="my-4">회원가입</h3>
	<div class="text-danger mb-2">*는 필수입력항목입니다.</div>
	<form>
		<table class="tb-row">
			<colgroup>
				<col width="180px">
			</colgroup>
			<tr><th><span>*</span>회원명
					<td><div class="row">
							<div class="col-auto">
								<input type="text" name="name" class="form-control">
			</div></div></td></th></tr>
			<tr><th><span>*</span>아이디
					<td><div class="row">
							<div class="col-auto">
								<input type="text" name="userid" class="form-control">
			</div></div></td></th></tr>
			<tr><th><span>*</span>비밀번호
					<td><div class="row">
							<div class="col-auto">
								<input type="password" name="userpw" class="form-control">
			</div></div></td></th></tr>
			<tr><th><span>*</span>비밀번호 확인
					<td><div class="row">
							<div class="col-auto">
								<input type="password" name="userpw_ck" class="form-control">
			</div></div></td></th></tr>
			<tr><th><span>*</span>이메일
					<td><div class="row">
							<div class="col-auto">
								<input type="text" name="email" class="form-control">
			</div></div></td></th></tr>
			<tr><th>성별
					<td><div class="row">
							<div class="col-auto">
								<div class="form-check form-check-inline"> 
									<label>
										<input class="form-check-input" type="radio" name="gender" value="남" checked>남
									</label>
								</div>
								<div class="form-check form-check-inline"> 
									<label>
										<input class="form-check-input" type="radio" name="gender" value="여">여
									</label>
								</div>
							</div>
			</div></td></th></tr>
			<tr><th>프로필 이미지
					<td><div class="row">
							<div class="col-auto d-flex gap-3">
							<label>
								<input type="file" name="file" id="file-single" class="form-control image-only" accept="image/*">
								<a class="btn btn-secondary btn-sm">
<!-- 								<i class="fa-regular fa-address-card me-2"></i>프로필</a> -->
								<i class="fa-solid fa-poo me-2"></i>프로필</a>
							</label>
							<div class="d-flex gap-2 align-items-center" id="file-attach">
								<span class="file-preview"></span>
								<i role="button" class="file-delete d-none fa-regular fa-circle-xmark text-danger fs-4"></i>
							</div>
							</div>
						</div></td></th></tr>
			<tr><th>생년월일
					<td><div class="row">
							<div class="col-auto d-flex align-items-center">
								<input type="text" name="birth" class="form-control date">
								<i role="button" class="date-delete fa-regular fa-calendar-xmark text-danger fs-4"></i>
							</div>
						</div></td></th></tr>
			<tr><th>전화번호
					<td><div class="row">
							<div class="col-auto">
								<input type="text" name="phone" class="form-control">
							</div>
						</div></td></th></tr>
			<tr><th>주소
					<td>
					<div class="row align-items-center">
						<div class="col-auto pe-0">
							<a class="btn btn-secondary btn-sm" id="btn-post">
							<i class="fa-solid fa-magnifying-glass me-2"></i>주소찾기</a>
						</div>
						<div class="col-auto">
							<input type="text" class="form-control w-px90 text-center" readonly name="post">
						</div>
					</div>
					<div class="row mt-2">
							<div class="col-xl-7">
								<input type="text" name="address" class="form-control" readonly>
							</div>
							<div class="col-xl">
								<input type="text" name="address" class="form-control">
							</div>
						</div></td></th></tr>
						
		</table>
	</form>
	<div class="btn-toolbar gap-2 my-3 justify-content-center">
			<button class="btn btn-primary">회원가입</button>
			<button type="button" class="btn btn-outline-primary px-4">취소</button>
		</div>
		
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script>
// $('#btn-post').click(function(){
$('#btn-post').on('click', function(){
	new daum.Postcode({
        oncomplete: function(data) {
        	console.log(data)
//         	if(data.userSelectedType=="R"){
//         		data.roadAddress
//         	}else {
//         		data.jibunAddress
//         	}
        	var address = data.userSelectedType=="R" ? data.roadAddress : data.jibunAddress;
        	if(data.buildingName!="") address += " ("+data.buildingName+")";
        	//경열로 3번지 (한국도로공사)
        	
        	$('[name=address]:eq(0)').val(address); 
//         	$('[name=address]').eq(0).val(address); 
        	$('[name=post]').val(data.zonecode);
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분입니다.
            // 예제를 참고하여 다양한 활용법을 확인해 보세요.
        }
    }).open();
})

$(function(){
	var today = new Date();
	// 년도 : 13년 전 해의 12월 31일까지는 선택 가능
// 	var endDay = new Date(today.getFullYear()-13, today.getMonth(), today.getDate()-1);
	// 만 나이를 적용한다면 : 13년 전 해의 오늘 날짜 이전까지는 선택 가능
	var endDay = new Date(today.getFullYear()-13, 11, 31);
	$('[name=birth]').datepicker('option', 'maxDate', endDay);
})

</script>
		
</body>
</html>