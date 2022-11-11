package co.newcomers.prj.itemlist.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.newcomers.prj.common.Command;
import co.newcomers.prj.itemlist.service.ItemService;
import co.newcomers.prj.itemlist.service.impl.ItemServiceImpl;
import co.newcomers.prj.itemlist.vo.ItemVO;

public class CategoryFilter implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 카테고리값 가져오기
		ItemService dao = new ItemServiceImpl();
		List<ItemVO> list= new ArrayList<>();
		String category = request.getParameter("category");
		System.out.println(category);
		
		String go = "";
		if(category.equals("생선")) {
			list = dao.categorySelectList(category);
			go = "fishCategory";	
		}else if(category.equals("베이커리")){
			list = dao.categorySelectList(category);
			go ="bakeryCategory";
		}else if(category.equals("반찬")){
			list = dao.categorySelectList(category);
			go ="sideDishCategory";
		}else if(category.equals("젤리")){
			list = dao.categorySelectList(category);
			go ="jellyCategory";
		}else if(category.equals("반려동물용품")){
			list = dao.categorySelectList(category);
			go ="animalCategory";
		}
		
		request.setAttribute("items", list);
		return "item/"+go+".tiles";
	}

}
