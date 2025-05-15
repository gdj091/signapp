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
</style>
</head>
<body>
	<h1>1군 선수단</h1>
	<h4>감독 : ${loginMember.memberId}</h4>
	<a href="/admin/match">선발명단 조회</a>
	
	<c:set var="matchCount" value="0" />
		<c:forEach var="m" items="${memberList}">
			  <c:if test="${m.memberSub eq 'MATCH'}">
	 		  <c:set var="matchCount" value="${matchCount + 1}" />
		  </c:if>
	</c:forEach>
	  <table border="1">
	    <tr>
	      <th>등번호</th>
	      <th>이름</th>
	      <th>다음경기선발</th>
	      <th>역할</th>
	      <th>포지션</th>
	      <th>변경</th>
	      <th>방출</th>
	    </tr>
	    <c:forEach var="m" items="${memberList}">
  		<c:if test="${m.memberRole eq 'MEMBER'}">
	      <form method="post" action="/admin/updateRole" onsubmit=" if(this.memberRole.value != 'COACH' 
	     											 	&& this.memberPosition.value == 'COACH') {
	    	  											alert('선수는 포지션에 COACH를 선택할 수 없습니다.');
				     									 return false;
				     						 			}else if(this.memberRole.value == 'ADMIN' 
		     											 		||this.memberPosition.value == 'ADMIN'){
				     						 				 return confirm('은퇴 후 코치로 전향시키겠습니까?');
				     						 			}
	      												 return confirm('정말 변경하시겠습니까?');">
	      <tr>
	        <td>${m.memberNo}</td>
	        <td>${m.memberId}</td>
	        <td>
	        	<select name="memberSub">
				  <option value="SUB" ${m.memberSub eq 'SUB' ? 'selected' : ''}>후보</option>
				  <option value="MATCH"
				    ${m.memberSub eq 'MATCH' ? 'selected' : ''}
				    ${matchCount >= 11 && m.memberSub ne 'MATCH' ? 'disabled' : ''}
				  >선발</option>
				</select>
	        </td>
	        
	        <!-- ROLE 선택 -->
	        <td>
	          <select name="memberRole">
	            <option value="MEMBER" ${m.memberRole eq 'MEMBER' ? 'selected' : ''}>선수</option>
	            <option value="ADMIN" style="color: gray;" ${m.memberRole eq 'ADMIN' ? 'selected' : ''}>코치</option>
	          </select>
	        </td>
	        
	        <!-- POSITION 입력 -->
	        <td>
	         <select name="memberPosition">
			    <option value="COACH" style="color: gray;" ${m.memberPosition eq 'COACH' ? 'selected' : ''}>코치</option>
			    <option value="FW" style="color: red;" ${m.memberPosition eq 'FW' ? 'selected' : ''}>공격수</option>
			    <option value="MF" style="color: blue;" ${m.memberPosition eq 'MF' ? 'selected' : ''}>미드필더</option>
			    <option value="DF" style="color: orange;" ${m.memberPosition eq 'DF' ? 'selected' : ''}>수비수</option>
			    <option value="GK" style="color: green;" ${m.memberPosition eq 'GK' ? 'selected' : ''}>골키퍼</option>
			  </select>
	        </td>
	        
	        <!-- 수정 -->
	        <td>
	          <input type="hidden" name="memberNo" value="${m.memberNo}" />
	          <input type="hidden" name="memberData" value="${m.memberData}" />
	          <input type="hidden" name="memberId" value="${m.memberId}" />
	          <button type="submit">결정</button>
	        </td>
	      </form>
	      
			<!-- 삭제 -->	      
	      <td>
		        <form method="post" action="/admin/deleteMember"
	    			  onsubmit="return confirm('정말 방출하시겠습니까?');"
	   				   style="display:inline;">
	  			<input type="hidden" name="memberId" value="${m.memberId}" />
	  				<button type="submit">방출</button>
				</form>
	        </td>
	      </tr>
	    </c:if>
	    </c:forEach>
	  </table>
	  
	<!-- 추가 -->
	<tr>
	  <form method="post" action="/admin/insertMember"
	        onsubmit="return confirm('영입하시겠습니까?');">
	    <td><input type="text" name="memberNo" placeholder="등번호" required></td>
	    <td><input type="text" name="memberId" placeholder="이름" required></td>
	    <td>
	      <select name="memberRole" required>
	        <option value="MEMBER">선수</option>
	        <option value="ADMIN">코치</option>
	      </select>
	    </td>
	    <td>
	      <select name="memberPosition" required>
	        <option value="COACH">COACH</option>
	        <option value="FW">FW</option>
	        <option value="MF">MF</option>
	        <option value="DF">DF</option>
	        <option value="GK">GK</option>
	      </select>
	    </td>
	    <td>
	      <input type="password" name="memberPw" placeholder="비밀번호" required />
	      <button type="submit">영입</button>
	    </td>
	  </form>
	</tr>
	
		<div><a href="/logout">로그아웃</a></div>
</body>
</html>