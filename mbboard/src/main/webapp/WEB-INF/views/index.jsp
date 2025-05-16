<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
  background-color: #f2f6fa;
  color: #1C2C5B;
  font-family: 'Segoe UI', sans-serif;
  margin: 40px;
}

h2 {
  color: #6CABDD;
  border-bottom: 2px solid #1C2C5B;
  padding-bottom: 5px;
}

table {
  width: 100%;
  border-collapse: collapse;
  margin-top: 20px;
  background-color: #ffffff;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
}

th, td {
  border: 1px solid #dcdcdc;
  padding: 12px;
  text-align: center;
}

th {
  background-color: #6CABDD;
  color: #ffffff;
}

td {
  color: #1C2C5B;
}

a {
  color: #6CABDD;
  text-decoration: none;
  font-weight: bold;
}

a:hover {
  text-decoration: underline;
}

button {
  background-color: #6CABDD;
  color: #ffffff;
  border: none;
  padding: 8px 16px;
  border-radius: 4px;
  cursor: pointer;
  font-weight: bold;
}

button:hover {
  background-color: #1C2C5B;
}

input[type="text"], input[type="password"], select {
  background-color: #ffffff;
  color: #1C2C5B;
  border: 1px solid #dcdcdc;
  padding: 6px;
  border-radius: 4px;
}
</style>
</head>
<body>
	<a href="/login">로그인</a>
	<h2>전체</h2>
	<table border="1">
		<tr>
			<th>ANONYMOUS(TOTAL)</th>
			<th>MEMBER</th>
			<th>ADMIN</th>
		</tr>
		<tr>
			<td>${connectCountMapAll.ANONYMOUS}</td>
			<td>${connectCountMapAll.MEMBER}</td>
			<td>${connectCountMapAll.ADMIN}</td>
		</tr>
	</table>
	<h2>오늘</h2>
	<table border="1">
		<tr>
			<th>ANONYMOUS(TOTAL)</th>
			<th>MEMBER</th>
			<th>ADMIN</th>
		</tr>
		<tr>
			<td>${connectCountMapToday.ANONYMOUS}</td>
			<td>${connectCountMapToday.MEMBER}</td>
			<td>${connectCountMapToday.ADMIN}</td>
		</tr>
	</table>
	
	<h2>현재 서버의 접속자(톰켓서버안에 활성이된 세션의 개수)</h2>
	<table border="1">
		<tr>
			<th>TOTAL</th>
		</tr>
		<tr>
			<td>${currentConnectCount}</td>
		</tr>
	</table>
</body>
</html>