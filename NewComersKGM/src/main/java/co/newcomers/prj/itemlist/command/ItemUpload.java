package co.newcomers.prj.itemlist.command;



import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.newcomers.prj.common.Control;
import co.newcomers.prj.itemlist.service.ItemService;
import co.newcomers.prj.itemlist.service.impl.ItemServiceImpl;
import co.newcomers.prj.itemlist.vo.ItemVO;

public class ItemUpload implements Control {

	@Override
	public void exec(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		String saveDir = request.getSession().getServletContext().getRealPath("/upload/");
		System.out.println(saveDir);
		String encod = "UTF-8";
		int maxSize = 5 * 1024 * 1024; // 1킬로바이트(1024) -> 메가 -> 5메가
		
		MultipartRequest mr = new MultipartRequest(
				request, // 요청정보.
				saveDir, // 저장위치.
				maxSize, // 파일크기.
				encod, // 인코딩방식.
				new DefaultFileRenamePolicy() // 리네임 정책. 
				); 
		
		String code =mr.getParameter("itemCode");
		String title =mr.getParameter("itemTitle");
		String price =mr.getParameter("itemPrice");
		String image =mr.getFilesystemName("itemImage");
		
		int prc = Integer.parseInt(price); 
		
		
		ItemVO vo = new ItemVO();
		vo.setItemCode(code);
		vo.setItemTitle(title);
		vo.setItemPrice(prc);
		vo.setItemImage(image);
		
		// 디비 입력. 
		ItemService service = new ItemServiceImpl();
		service.itemInsert(vo);
		
		//service.itemInsert(new ItemVO(code, title, prc, image));
		response.sendRedirect("category.do");
	}

}