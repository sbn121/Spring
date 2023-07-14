<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<select class="form-select" id="sido">
	<option value=''>시도 선택</option>
	<c:forEach items="${list.items.item }" var="vo">
		<option value='${vo.orgCd }'>${vo.orgdownNm }</option>	
	</c:forEach>
</select>

<script>
	$('#sido').change(function(){
		animal_sigungu();
		animal_list(1);
	})
	
	//시도에 따른 시군구 조회
	function animal_sigungu(){
		$('#sigungu').remove();
		$('#shelter').remove(); //시도+시군구가 모두 있는 경우만 보호소조회 가능
		if($('#sido').val()=='') return; //시도선택 이란 기본을 선택시는 시군구 조회할 수 없음
		
		$.ajax({
			url: 'animal/sigungu',
			data: {sido:$('#sido').val()}
		}).done(function(response){
			$('#sido').after(response);
		})
	}
	
</script>