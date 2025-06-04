<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/signature_pad@4.1.7/dist/signature_pad.umd.min.js"></script>
<script>
	$(document).ready(function() {
	//캔버스에 사인 후 객체로 받는 signaturePad 생성자
	const signaturePad = new SignaturePad($('canvas')[0], {
		minWidth :	2,
		maxWidth :	2,
		penColor : "#000000"
	});
	
	// 캔버스 내용을 초기화하느 signaturePad API clear 메서드
	$('#btnClear').click(function(){
		signaturePad.clear();
	});
	
	// AJAX로 signaturePad객체안 사인이미지를 서버로 전송
	$('#btnSign').click(function(){
		if(signaturePad.isEmpty()){
			alert('사인을 먼저 해주세요');
		}else{
		//$.ajax({}).done().fail();
			
			
		$.ajax({
			async : true // true면 비동기(백그라운드로 실행)
			,url : '/addSign'
			,type : 'post'
			,data : {
				id:$('#id').text()
				 ,signImg : signaturePad.toDataURL() // signaturePad.toDataURL("image/jpeg"); 인수 생략시 기본값은 png이미지
			} // 로그인 사용자 id와 signaturePad안에 있는 이미지를 보냄
		}).done(function(data){
			alert(data); // data = '결제완료'
			// 사인을 초기화..
			// js로 페이지 이동 location.href='이동할페이지'
		}).fail(function(){
			alert('결제실패');
		});
	}
	});
});
</script>
</head>


<body>
	<!-- AJAX통신 / id:사인레벨이 되는 로그인 사용자id -->
	<div id="id">manager</div> <!-- <input id="id" type="text" value="manage" -->
	<canvas style="border : 1px solid #FF0000;" id="signCanvas"></canvas>
	<br>
	<button type="button" id="btnClear">지우기</button>
	<button type="button" id="btnSign">결제확인</button>
</body>
</html>