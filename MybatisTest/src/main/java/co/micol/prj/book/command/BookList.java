package co.micol.prj.book.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.micol.prj.book.service.BookService;
import co.micol.prj.book.service.impl.BookServiceImpl;
import co.micol.prj.book.vo.BookVO;
import co.micol.prj.common.Command;

public class BookList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 책목록 가져오기
		BookService dao = new BookServiceImpl();
		List<BookVO> books = new ArrayList<>();
		books = dao.bookSelectList(); //전체목록
		request.setAttribute("books", books); //결과를 담음(jsp페이지에서 사용할 변수 "books"
		// 전달하려고 set
		return "book/bookList"; //jsp 쓰지 x resolve가 해주므로
	}

}
