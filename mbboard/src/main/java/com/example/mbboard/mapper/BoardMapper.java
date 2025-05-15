package com.example.mbboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.mbboard.dto.Board;
import com.example.mbboard.dto.Page;

@Mapper // -> @component 구현클래스를 자동으로 생성 ex) @component BoardMapper_class -> 객체생성 bean등록
public interface BoardMapper {
	
	List<Board> selectBoardListByPage(Page page);
	Board selectBoardOne(Board b);
	int countBoard(@Param("searchWord") String searchWord);
	int insertBoard(Board b);
	int updateBoard(Board b);
	int deleteBoardByKey(Board b);
}
