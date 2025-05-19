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
	<h1>비밀번호찾기</h1>
	<form method="post" action="/findMemberPw">
		선수/코치 코드 : <input type = "text" name="memberId">
		<br>
		이메일 : <input type = "text" name="email">
		<br>
		<button type="submit">비밀번호찾기</button>
		* 10분안에 비밀번호 변경
	</form>
</body>
</html>