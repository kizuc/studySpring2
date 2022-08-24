package com.itwillbs.dao;

import java.util.List;

import com.itwillbs.domain.BoardDTO;
import com.itwillbs.domain.PageDTO;

public interface BoardDAO {

	void insertBoard(BoardDTO boardDTO);

	Integer getMaxNum();

	List<BoardDTO> getBoardList(PageDTO pageDTO);

	int getBoardCount();

	BoardDTO getBoard(int num);

	BoardDTO getBoard();

	BoardDTO numCheck(BoardDTO boardDTO);

	void updateBoard(BoardDTO boardDTO);

}
