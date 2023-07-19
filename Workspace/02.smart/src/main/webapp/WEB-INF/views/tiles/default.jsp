<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<c:choose>
	<c:when test="${category eq 'login'}"><c:set var="title" value="로그인"/></c:when>
	<c:when test="${category eq 'error'}"><c:set var="title" value="오류"/></c:when>
</c:choose>
    
<html>
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>스마트웹&amp;앱 ${title}</title>
<c:set var="now" value="<%=new java.util.Date() %>"/> 
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<c:url value='/img/hanul.ico' />" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="<c:url value='/css/styles.css?${now }'/>" rel="stylesheet" />
        <link href="<c:url value='/css/common.css?${now }'/>" rel="stylesheet" />
        <link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
  
<!--  cdnjs.com > fontawesome 검색 > styling, javascript 선언문 복사해서 넣기 -->        
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"/>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/js/all.min.js" ></script>
<!--  //fontawesome -->
		<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
        <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
		<script src="<c:url value='/js/common.js?${now }'/>"></script>
    </head>

<body class="bg-primary">

   	<!-- Page content-->
    <div class="container">
        <tiles:insertAttribute name="container"/>
    </div>

	<!-- Bootstrap core JS-->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
	<!-- Core theme JS-->
	<script src="<c:url value='/js/scripts.js'/>"></script>
</body>
</html>