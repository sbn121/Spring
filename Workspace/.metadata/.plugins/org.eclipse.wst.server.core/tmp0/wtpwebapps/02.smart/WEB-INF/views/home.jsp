<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" pageEncoding="utf-8" contentType="text/html; charset=utf-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h3 class="my-4">스마트 웹&amp;앱 과정</h3>
<img style="width:100%" src="img/hanul.png">
상품명: <input type="text" id="name">
가격: <input type="text" id="price" value="0">
<button onclick="test1()">보내기(jsp)</button>
<button onclick="xml()">보내기(xml)</button>
<div id="xml-result"></div>

<table  id="ajax-result">
<tr><th>상품명</th><th>가격</th></tr>
<tr><td>우유</td><td>1000</td></tr>
<tr><td>콜라</td><td>1200</td></tr>
<tr><td>커피</td><td>1500</td></tr>
</table>


<script>
function xml(){
	$.ajax({
		url: 'xml',
	}).done(function( response ){
// 		console.log( response )
		console.log( $(response).find("product") )
		var tag = '';
		$(response).find("product").each(function(){
			var name = $(this).find("name").text()
			var price = $(this).find("price").text()
			tag += `<div><span>\${name}</span><span>\${price}</span></div>`;
// 			var tag = `<div><span>\${name}</span><span>\${price}</span></div>`;
// 			$('#xml-result').append( tag )
		})
		$('#xml-result').html( tag )
	})
	
}

function test1() {
	$.ajax({
		url: 'test1',
	// 	type: 'post',
		data: { name: $('#name').val(), price: $("#price").val() },
	}).done(function( response ){
		console.log( response )
		$('#ajax-result').append( response )
		
	})
}
</script>

</body>
</html>
