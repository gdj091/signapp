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
    background-color: #1e1e1e;
    color: #e0e0e0;
    font-family: 'Segoe UI', sans-serif;
    margin: 40px;
  }

  h2 {
    color: #ffffff;
    border-bottom: 2px solid #444;
    padding-bottom: 5px;
  }

  table {
    width: 100%;
    border-collapse: collapse;
    margin-top: 20px;
    background-color: #2a2a2a;
  }

  th, td {
    border: 1px solid #444;
    padding: 10px;
    text-align: center;
  }

  th {
    background-color: #333;
    color: #ffffff;
  }

  td {
    color: #ddd;
  }

  a {
    color: #4ea1ff;
    text-decoration: none;
  }

  a:hover {
    text-decoration: underline;
  }

  input[type="text"] {
    background-color: #333;
    color: #eee;
    border: 1px solid #555;
    padding: 6px;
    border-radius: 4px;
  }

  button {
    background-color: #555;
    color: #fff;
    border: none;
    padding: 6px 12px;
    border-radius: 4px;
    cursor: pointer;
  }

  button:hover {
    background-color: #777;
  }

  .pagination a {
    margin: 0 4px;
    color: #ccc;
    
  }
</style>
</head>
<body>
	<h2>게시판 목록</h2>
	<form method="get" action="boardList">
	    <input type="text" name="searchWord" placeholder="검색어 입력" >
	    <button type="submit">검색</button>
	</form>
	<a href="insertBoard"> + 리스트추가</a>	
	
	<table border="1">
	    <tr>
	        <th>번호</th>
	        <th>제목</th>
	        <th>작성자</th>
	        <th>작성일</th>
	    </tr>
	    <!-- 게시글 리스트 반복 출력 -->
	    <c:forEach var="b" items="${list}">
	        <tr>
	            <td>${b.boardNo}</td>
	            <td><a href="boardOne?boardNo=${b.boardNo}">${b.boardTitle}</a></td>
	            <td>${b.boardUser}</td>
	            <td>${b.createdate}</td>
	        </tr>
	    </c:forEach>
	</table>
	
	<!-- 페이지 번호 출력 -->
	<div class="pagination">
  	  <c:if test="${page.currentPage > 1}">
	    <a href="boardList?currentPage=${page.currentPage - 1}&searchWord=${page.searchWord}">« 이전</a>
	  </c:if>
	
	  <c:if test="${page.currentPage < page.lastPage}">
	    <a href="boardList?currentPage=${page.currentPage + 1}&searchWord=${page.searchWord}">다음 »</a>
	  </c:if>
	</div>
	<br>
	
	<!-- 검색어가 있는 경우: 검색어 포함한 링크 생성 -->
	<!-- 검색어 없는 경우: 페이지 번호만 포함한 링크 생성 -->
	<div>
	전체 페이지 목록
		<br>
	    <c:forEach var="i" begin="1" end="${page.lastPage}">
		    <c:choose>
		        <c:when test="${not empty page.searchWord}">
		            <a href="boardList?currentPage=${i}&searchWord=${page.searchWord}">${i}</a>
		        </c:when>
		        <c:otherwise>
		            <a href="boardList?currentPage=${i}">${i}</a>
		        </c:otherwise>
		    </c:choose>
		</c:forEach>
	</div>
</body>
</html>