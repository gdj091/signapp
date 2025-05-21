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
	<h3>비밀번호 변경</h3>
	<form action="/updatePassword" method="post">
	    <input type="hidden" name="id" value="${loginMember.id}">
	    새 비밀번호: <input type="password" name="newPw" id="newPw">
	    <button type="submit" id="changeBtn">변경</button>
	</form>
	<span id="pwMsg" style="color:red;"></span>
	
	<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	<script>
	    $("#changeBtn").click(function(e) {
	        e.preventDefault();
	        const id = "${loginMember.id}";
	        const newPw = $("#newPw").val();
	
	        $.post("/checkPwHistory", { id: id, pw: newPw }, function(result) {
	            if (result === "used") {
	                $("#pwMsg").text("이미 사용한 비밀번호입니다.");
	            } else {
	                $("#pwMsg").text("");
	                $("form").off("submit").submit(); // submit 정상 진행
	            }
	        });
	    });
	</script>
	
	<c:if test="${not empty msg}">
	    <p style="color:blue;">${msg}</p>
	</c:if>
</body>
</html>