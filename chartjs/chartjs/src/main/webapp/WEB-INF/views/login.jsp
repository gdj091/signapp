<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>로그인</h2>
    <form action="/login" method="post">
        아이디: <input type="text" name="id"><br>
        비밀번호: <input type="password" name="pw"><br>
        <button type="submit">로그인</button>
    </form>

    <c:if test="${not empty msg}">
        <p style="color:red;">${msg}</p>
    </c:if>
</body>
</html>