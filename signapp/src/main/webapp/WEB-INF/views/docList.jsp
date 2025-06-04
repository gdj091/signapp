<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>번호</td>
			<td>제목</td>
			<td>작성일</td>
		</tr>
		 <c:forEach var="doc" items="${docList}">
		<tr>
			<td>${doc.docId}</td>
			<td>${doc.title}</td>
			<td>${doc.createdAt}</td>
		</tr>
		</c:forEach>
	</table>
		<p>총 문서 수: ${fn:length(docList)}</p>
</body>
</html>