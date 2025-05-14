package com.example.mbboard.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;
import com.example.mbboard.mapper.BoardMapper;
import com.example.mbboard.service.IBoardService;

@Controller
public class BoardController {
	@Autowired IBoardService boardService; //->디커플링
	@Autowired BoardMapper boardMapper;
	
	// 게시글 목록 페이지 요청 처리 (페이징 + 검색 포함)
	@GetMapping("/boardList")
	public String boardList(Model model,
	                        @RequestParam(defaultValue = "1") int currentPage,
	                        @RequestParam(required = false) String searchWord) {
	    int rowPerPage = 10;
	    int totalCount = boardMapper.countBoard(searchWord); // 검색어 포함된 전체 글 수
	    Page page = new Page(rowPerPage, currentPage, totalCount, searchWord);

	    List<Board> list = boardService.getBoardList(page);
	    model.addAttribute("list", list);// 뷰에 전달
	    model.addAttribute("page", page);

	    return "boardList"; // boardList.jsp로 이동
	    
	}
		//boardOne
	    @GetMapping("/boardOne")
	    public String boardOne(Model model, @RequestParam int boardNo) {
	        Board board = boardService.getBoardOne(boardNo);
	        model.addAttribute("board", board);
	        return "boardOne";
	}
	    
	    //insert
	    @GetMapping("/insertBoard")
	    public String insertBoardForm() {
	    	return "insertBoard"; 
	    }
	    @PostMapping("/insertBoard")
	    public String insertBoard(Board board) {
	        boardService.insertBoard(board); // 게시글 DB에 추가
	        return "redirect:/boardList";
	    }
	    
	    //delete
	    @PostMapping("/deleteBoardByKey")
	    public String deleteBoardByKey(@RequestParam int boardNo) {
	        boardService.deleteBoardByKey(boardNo);
	        return "redirect:/boardList";
	    }
	    
	    
	    
	    //update
	    @GetMapping("/updateBoard")
	    public String updateBoardForm(@RequestParam int boardNo, Model model) {
	        Board board = boardService.getBoardOne(boardNo);
	        model.addAttribute("board", board);// 수정 폼에 기존 데이터 전달
	        return "updateBoard"; // -> updateBoard.jsp
	    }
	    @PostMapping("/updateBoard")
	    public String updateBoard(Board board) {
	        boardService.updateBoard(board);
	        return "redirect:/boardOne?boardNo=" + board.getBoardNo();
	    }
	    
}
