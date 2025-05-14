package com.example.mbboard.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Transactional
@Slf4j
public class BoardService implements IBoardService {
	@Autowired BoardMapper boardMapper; // 인터페이스 형태로 의존성 주입 -> 디커플링
	
	public List<Board> getBoardList(Page page) {
	    return boardMapper.selectBoardListByPage(page);
	}
	
	 // 전체 게시글 수 조회 (검색어 포함)
	@Override
	public int countBoard(String searchWord) {
	    return boardMapper.countBoard(searchWord);  // 검색어에 해당하는 게시글 수 반환
	}
	
	@Override
	public Board getBoardOne(int boardNo) {
		// 조회할 게시글 번호를 가진 Board 객체 생성
		Board b = new Board();
	    b.setBoardNo(boardNo);
	    // 게시글 번호에 해당하는 게시글 정보 반환
		return boardMapper.selectBoardOne(b);
	}
	
	@Override
	public void insertBoard(Board board) {
	    boardMapper.insertBoard(board); // 전달받은 Board객체를 DB에 삽입
	}
	
	//delete
	@Override
	public void deleteBoardByKey(int boardNo) {
		// 삭제할 게시글 번호를 Board 객체에 세팅
	    Board b = new Board();
	    b.setBoardNo(boardNo);
	    boardMapper.deleteBoardByKey(b);
	}
	
	//update
	@Override
	public void updateBoard(Board board) {
		// 전달받은 Board 객체 내용을 바탕으로 DB 수정
	    boardMapper.updateBoard(board);
	}
}
