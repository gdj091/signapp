<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>문서 업로드</h2>
    <form action="/uploadDoc" method="post">
        제목: <input type="text" name="title"><br>
        내용: <br>
        <textarea name="content" rows="10" cols="40"></textarea><br>
        <button type="submit">업로드</button>
    </form>
</body>
</html>