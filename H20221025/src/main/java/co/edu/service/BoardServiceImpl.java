package co.edu.service;

import java.util.List;

import co.edu.board.BoardVO;
import co.edu.board.MemberVO;
import co.edu.dao.BoardDAO;
import co.edu.dao.MemberDAO;

public class BoardServiceImpl implements BoardService {
	
	BoardDAO dao = new BoardDAO();
	MemberDAO vo1 = new MemberDAO();
	
	@Override
	public BoardVO insertBoard(BoardVO vo) {
		return dao.insertBoard(vo);
	}

	@Override
	public List<BoardVO> getList(BoardVO vo) {
		return dao.boardList(vo);
	}

	@Override
	public BoardVO findBoard(int boardNo) {
		return dao.searchBoard(boardNo);
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		return false;
	}

	@Override
	public boolean deleteBoard(int boardNo) {
		return false;
	}

	@Override
	public List<BoardVO> pageList(int page) {
		return dao.pageList(page);
	}

	@Override
	public MemberVO addMember(MemberVO vo) {
		return vo1.memberInsert(vo);
		
	}

	@Override
	public List<MemberVO> memberList() {
		return dao.memberList();
	}

	@Override
	public MemberVO login(String id, String passwd) {
		return vo1.login(id, passwd);
	}

	

}
