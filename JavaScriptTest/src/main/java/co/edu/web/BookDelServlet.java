package co.edu.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import co.edu.book.BookVO;
import co.edu.common.BookDAO;

@WebServlet("/BookDelServlet")
public class BookDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookDelServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding(("utf-8"));
		response.setContentType("text/json;charset=utf-8");
		BookDAO dao = new BookDAO();
		// 삭제.
		BookVO vo = new BookVO();
		String bCode = request.getParameter("book_code");
			
			dao.deleteBook(bCode);
			Gson gson = new GsonBuilder().create();
			response.getWriter().print(gson.toJson(vo));
		
	}
}
