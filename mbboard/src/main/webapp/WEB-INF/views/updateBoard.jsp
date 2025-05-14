<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    text-align: left;
  }

  th {
    background-color: #333;
    color: #ffffff;
    width: 120px;
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

  input[type="text"], textarea {
    width: 100%;
    background-color: #333;
    color: #eee;
    border: 1px solid #555;
    padding: 8px;
    border-radius: 4px;
    box-sizing: border-box;
    resize: vertical;
  }

  textarea {
    height: 120px;
  }

  button {
    background-color: #555;
    color: #fff;
    border: none;
    padding: 8px 16px;
    border-radius: 4px;
    cursor: pointer;
    margin-top: 10px;
  }

  button:hover {
    background-color: #777;
  }

  .pagination a {
    margin: 0 4px;
    color: #ccc;
  }

  .form-actions {
    margin-top: 20px;
  }

  .form-actions a {
    margin-left: 12px;
    color: #aaa;
  }
</style>
</head>
<body>
    <h2>게시글 수정하기</h2>
	<form method="post" action="/updateBoard">
	  <input type="hidden" name="boardNo" value="${board.boardNo}">
		<table border="1">
	            <tr>
	                <th>제목</th>
	                <td> <input type="text" name="boardTitle" value="${board.boardTitle}"></td>
	            </tr>
	            <tr>
	                <th>작성자</th>
	                <td><input type="text" name="boardUser" value="${board.boardUser}"></td>
	            </tr>
	            <tr>
	                <th>내용</th>
	                <td> <textarea name="boardContent">${board.boardContent}</textarea></td>
	            </tr>
	        </table>
	    <br>
   		 <button type="submit">수정하기</button>
	</form>
	    <br>
	    <a href="boardList">목록으로</a>
</body>
</html>