<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<h3>유기동물 목록</h3>
<c:if test="${empty list.items.item }">
	<table class="tb-list empty">
	<tr><th>해당 유기동물이 없습니다.</th></tr>
	</table>
</c:if>
<c:forEach items="${list.items.item }" var="vo">
	<table class="tb-list animal mb-3">
		<colgroup>
			<col width="120px">
			<col width="100px"><col width="60px">
			<col width="70px"><col width="160px">
			<col width="70px"><col width="160px">
			<col width="70px"><col width="120px">
			<col width="70px"><col width="160px">
			<col width="110px"><col width="110px">
		</colgroup>
	
	<tr>
		<td rowspan="3">
			<div class="text-center popfile">
				<img src="${vo.popfile}" style="width: 120px; height: 120px">
			</div>
		</td>
		<th>성별</th><td>${vo.sexCd }</td>
		<th>나이</th><td>${vo.age }</td>
		<th>체중</th><td>${vo.weight }</td>
		<th>색상</th><td>${vo.colorCd }</td>
		<th>접수일자</th><td>${vo.happenDt }</td>
	</tr>
	<tr>
		<th>특징</th><td colspan="9">${vo.specialMark }</td>
	</tr>
	<tr>
		<th>발견장소</th><td colspan="7">${vo.happenPlace }</td>
		<td colspan="2">${vo.processState }</td>
	</tr>
	<tr>
		<td colspan="2">${vo.careNm }</td>
		<td colspan="7" class="text-start">${vo.careAddr }</td>
		<td colspan="2">${vo.careTel }</td>
	</tr>
	</table>
</c:forEach>

<script>
	makePage(${list.totalCount}, ${list.pageNo});
</script>
