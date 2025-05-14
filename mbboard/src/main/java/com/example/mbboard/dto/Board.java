package com.example.mbboard.dto;

import lombok.Data;

@Data
public class Board {
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String boardUser;
	private String updatedate;
	private String createdate;
	
	
	//👨‍💼 컨트롤러 (Controller)		BoardController		고객 상담 직원: 요청받고 전달함
	//🧠 서비스 인터페이스			IBoardService		서비스 매뉴얼: 뭘 할 수 있는지 정의함
	//🛠 서비스 구현체				BoardService		진짜 일 처리하는 직원
	//🧾 매퍼 인터페이스				BoardMapper			DB랑 직접 소통하는 부서 (SQL 담당자)
}
