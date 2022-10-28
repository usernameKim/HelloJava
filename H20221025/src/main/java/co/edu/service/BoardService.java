package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;

public interface BoardService {
	// 기능만 정의.
		public BoardVO insertBoard(BoardVO vo); // 추가
		public List<BoardVO> getList(BoardVO vo); // 전체목록
		public BoardVO findBoard(int boardNo); // 한건조회
		public boolean updateBoard(BoardVO vo); // 수정
		public boolean deleteBoard(int boardNo); //번호로 삭제
		
		public MemberVO addMember(MemberVO vo); // 가입
		
	// 페이지.
		public List<BoardVO> pageList(int page);
		
	// 회원목록.
		public List<MemberVO> memberList();
		
		public MemberVO login(String id, String passwd);
		
		
}
