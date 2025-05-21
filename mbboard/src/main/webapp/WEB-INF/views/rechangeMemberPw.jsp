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
body::before {
  content: "";
  position: absolute;
  top: 10px;
  right: 10px;
  width: 50px;
  height: 50px;
  background-image: url('https://upload.wikimedia.org/wikipedia/en/e/eb/Manchester_City_FC_badge.svg');
  background-size: contain;
  background-repeat: no-repeat;
  z-index: 10;
}
</style>
</head>
<body>
	<h1>rechangeMemberPw</h1>
	<form method="post" action="/rechangeMemberPw">
		<div>
			선수/코치 이름 <input type="text" name="memberId">
		</div>
		<div>
			전송 받은 비밀번호 <input type="password" name="memberPw">
		</div>
		<div>
			변경할 비밀번호 <input type="password" name="reMemberPw">
		</div>
		<button type="submit">패스워드변경</button>
		
		<!-- 
			UPDATE member
			SET member_pw = reMemberPw
			WHERE member_pw = memberPw
			AND pwcktime is NOT NULL
			AND TIMESTAMPDIFF(MINUTE, pwcktime, NOW()) < 11
		 -->
	</form>
	
	<c:if test="${not empty error}">
	    <div style="color:red;">${error}</div>
	</c:if>
</body>
</html>