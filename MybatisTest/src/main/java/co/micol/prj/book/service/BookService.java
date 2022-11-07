package co.micol.prj.book.service;

import java.util.List;

import co.micol.prj.book.vo.BookVO;

// interface는 service이름 많이 붙임, 스스로 구현 못해서 구현체 만들어야함
public interface BookService {
	List<BookVO> bookSelectList();  //book 전체리스트 가져오기getBookList라고 쓰기도 함. <----->set(값을 담음)(R)
	BookVO bookSelect(BookVO vo);	//한권의 책 상세내역 가져오기(R) getBook
	int bookInsert(BookVO vo);		// 도서입력(C) setBook
	int bookDelete(BookVO vo);		// 도서삭제(D) deleteBook
	int bookUpdate(BookVO vo);		// 도서변경(U) updateBook
}
