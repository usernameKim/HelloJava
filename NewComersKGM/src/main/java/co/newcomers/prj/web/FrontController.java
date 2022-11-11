package co.newcomers.prj.web;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.newcomers.prj.common.Command;
import co.newcomers.prj.itemlist.command.Category;
import co.newcomers.prj.itemlist.command.CategoryFilter;
import co.newcomers.prj.itemlist.command.FishCategory;
import co.newcomers.prj.itemlist.command.ItemList;
import co.newcomers.prj.itemlist.command.AnimalCategory;
import co.newcomers.prj.itemlist.command.BakeryCategory;
import co.newcomers.prj.itemlist.command.JellyCategory;
import co.newcomers.prj.itemlist.command.SideDishCategory;
import co.newcomers.prj.main.MainCommand;

@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HashMap<String, Command> map = new HashMap<String, Command>();
    public FrontController() {
        super();

    }

	public void init(ServletConfig config) throws ServletException {
		//김경미
		map.put("/main.do", new MainCommand());
		map.put("/ItemList.do", new ItemList()); //상품목록보기
		map.put("/category.do", new Category()); //카테고리 페이지이동
		map.put("/fishCategory.do", new FishCategory()); //생선 카테고리
		map.put("/bakeryCategory.do", new BakeryCategory()); //베이커리 카테고리
		map.put("/sideDishCategory.do", new SideDishCategory()); //반찬 카테고리
		map.put("/jellyCategory.do", new JellyCategory());//젤리 카테고리
		map.put("/animalCategory.do", new AnimalCategory());//반려동물용품 카테고리
		map.put("/categoryFilter.do", new CategoryFilter()); //카테고리값 가져오기
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8"); // 한글깨짐방지
		String uri = request.getRequestURI(); // 요청한 uri를 구함
		String contextPath = request.getContextPath(); // 루트를 구함, context path
		String page = uri.substring(contextPath.length()); // 실제 수행할 요청을 구함

		Command command = map.get(page); // init 메소드에서 수행할 명령을 가져온다
		String viewPage = command.exec(request, response); // 명령을 수행하고 결과를 돌려받음

		// viewResolve 파트
		if (!viewPage.endsWith(".do") && viewPage != null) {
			// ajax 처리
			if(viewPage.startsWith("ajax:")){
				response.setContentType("text/html; charset=UTF-8");
				response.getWriter().append(viewPage.substring(5));
				return;
			}
			// 타일즈 돌아가는 곳
			if (!viewPage.endsWith(".tiles")) {
				viewPage = "/WEB-INF/views/" + viewPage + ".jsp"; //타일즈를 안태움
			}
			RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect(viewPage); // *.do로 들어올때 돌아가는 곳
		}
	}

}
