<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<!-- 로그인이 안되어있다면 -->
		<form method="post" action="/cookieLogin">
			<div>
				<h3>선수/코치 이름:</h3>
				<div>
					<input type="text" name="memberId" value="${cookie.saveId.value}"> <!-- cookie.getSaveId() -->
					<input type="checkbox" value="yes" name="saveIdCk">아이디 저장
				</div>
				<h3>비밀번호:</h3>
				<div><input type="text" name="memberPw"></div>
				<div><button type="submit">로그인</button></div>
			</div>
		</form>
</body>
</html>