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

@WebServlet("/BookAddServlet")
public class BookAddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BookAddServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("dopost");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding(("utf-8"));
		response.setContentType("text/json;charset=utf-8");

		BookDAO dao = new BookDAO();
		// 등록.
			String bCode = request.getParameter("book_code");
			String bName = request.getParameter("book_name");
			String at = request.getParameter("author");
			String ps = request.getParameter("press");
			int price = Integer.parseInt(request.getParameter("price"));
			 
			BookVO vo = new BookVO();
			vo.setBook_code(bCode);
			vo.setBook_name(bName);
			vo.setAuthor(at);
			vo.setPress(ps);
			vo.setPrice(price);
			
			dao.insertBook(vo);
			Gson gson = new GsonBuilder().create(); 
			response.getWriter().print(gson.toJson(vo));
		
		}
	}
