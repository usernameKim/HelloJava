package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;

public interface BoardService {
	// 기능만 정의.
		public BoardVO insertBoard(BoardVO vo);
		public List<BoardVO> getList(BoardVO vo); 
		public BoardVO findBoard(int boardNo); // 한건조회
		public boolean updateBoard(BoardVO vo);
		public boolean deleteBoard(int boardNo); //번호로 삭제
	
	// 페이지.
		public List<BoardVO> pageList(int page);
}
