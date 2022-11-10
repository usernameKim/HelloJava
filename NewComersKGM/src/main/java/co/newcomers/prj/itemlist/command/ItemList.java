package co.newcomers.prj.itemlist.command;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.newcomers.prj.common.Command;
import co.newcomers.prj.itemlist.service.ItemService;
import co.newcomers.prj.itemlist.service.impl.ItemServiceImpl;
import co.newcomers.prj.itemlist.vo.ItemVO;

public class ItemList implements Command {

	@Override
	public String exec(HttpServletRequest request, HttpServletResponse response) {
		// 상품목록 가져오기
		
		ItemService dao = new ItemServiceImpl();
		List<ItemVO> items = new ArrayList<>();
		items = dao.itemSelectList(); 
		request.setAttribute("items", items); 
		
		return "item/itemList"; 
	}

}
