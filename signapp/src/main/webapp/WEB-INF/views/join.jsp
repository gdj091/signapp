<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>회원가입</h2>
    <form action="/join" method="post">
        ID: <input type="text" name="id"><br>
        PW: <input type="password" name="pw"><br>
        Level: 
        <select name="level">
            <option value="1">1</option>
            <option value="2">2</option>
            <option value="3">3</option>
        </select><br>
        <button type="submit">가입</button>
    </form>
</body>
</html>