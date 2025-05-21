<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>선발 명단</title>
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
  <h2>선발 명단</h2>

  <c:if test="${not empty matchList}">
    <table border="1">
	      <tr>
	        <th>등번호</th>
	        <th>이름</th>
	        <th>포지션</th>
	      </tr>
      <c:forEach var="m" items="${matchList}">
		  <tr>
		    <td>${m.memberNo}</td>
		    <td>${m.memberId}</td>
		    <td>${m.memberPosition}</td>
		  </tr>
		</c:forEach>
    </table>
  </c:if>

  <c:if test="${empty matchList}">
    <p>선발된 선수가 없습니다.</p>
  </c:if>

  <br>
  <a href="/admin/adminHome">← 돌아가기</a>

</body>
</html>