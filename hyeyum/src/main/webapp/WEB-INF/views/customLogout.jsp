<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>혜윰대학교 종합정보시스템-혜윰누리</title>
</head>
<body>
	<h1> 로그아웃 페이지 </h1>
	<form method="post">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		<button>logout</button>
	</form>
</body>
</html>