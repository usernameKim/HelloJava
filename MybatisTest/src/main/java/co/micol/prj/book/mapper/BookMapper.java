package co.micol.prj.book.mapper;

import java.util.List;

import co.micol.prj.book.vo.BookVO; 
// service interface와 거의 일치(but 파라매터 전달방식이다름요)
public interface BookMapper {
	List<BookVO> bookSelectList();  //book 전체리스트 가져오기getBookList라고 쓰기도 함. <----->set(값을 담음)(R)
	BookVO bookSelect(BookVO vo);	//한권의 책 상세내역 가져오기(R) getBook
	int bookInsert(BookVO vo);		// 도서입력(C) setBook
	int bookDelete(BookVO vo);		// 도서삭제(D) deleteBook
	int bookUpdate(BookVO vo);		// 도서변경(U) updateBook
}
