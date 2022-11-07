package co.micol.prj.book.service.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import co.micol.prj.book.mapper.BookMapper;
import co.micol.prj.book.service.BookService;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.DataSource;

public class BookServiceImpl implements BookService {
	//session 연결 디폴트 false, auto commit 해달라 -> true
	private SqlSession sqlSession = DataSource.getInstance().openSession(true);
	// session을 통해 mapper 연결
	private BookMapper map = sqlSession.getMapper(BookMapper.class); //BookMapper(인터페이스명쓰기)
	
	//service 인터페이스와 mapper 인터페이스 같게 만들기
	@Override
	public List<BookVO> bookSelectList() {
		// 책 전체리스트
		return map.bookSelectList();
	}

	@Override
	public BookVO bookSelect(BookVO vo) {
		// 한권의 책 정보 가져오기
		return map.bookSelect(vo);
	}

	@Override
	public int bookInsert(BookVO vo) {
		// 책을 입력하는 곳
		return map.bookInsert(vo);
	}

	@Override
	public int bookDelete(BookVO vo) {
		// 책 삭제
		return map.bookDelete(vo);
	}

	@Override
	public int bookUpdate(BookVO vo) {
		// 책 내용 수정
		return map.bookUpdate(vo);
	}

}
