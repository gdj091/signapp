package com.example.mbboard.service;

import java.util.List;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

public interface IBoardService {
	List<Board> getBoardList(Page page); 	//리스트니까 List로
	int countBoard(String searchWord);		//페이징 숫자니까 int로
	Board getBoardOne(int boardNo);			//게시글 하나의 세부정보니까 Board타입
	void insertBoard(Board board);			//게시글 추가 삭제 업데이트만 하면되니까(돌려줄거없으니)void
	void deleteBoardByKey(int boardNo);
	void updateBoard(Board board);
}
