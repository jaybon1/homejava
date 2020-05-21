<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>

<script>
	function getData(){
		var loc = document.getElementById('myinput').value;
		location.href='second1.jsp?loc='+loc;
	}
</script>

</head>
<body>

	<h1>약국</h1>
	<br>
	지역을 검색하세요
	<br>
	
	<form>
	<input id='myinput'>
	<input type="button" value="확인하기" onclick="getData()">
	</form>
	
	<div id="view"></div>
	
</body>
</html>

