package co.edu.control;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.edu.common.Control;
import co.edu.common.HttpUtil;

public class WriteForm implements Control {

	@Override
	public void exec(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpUtil.forward(req, resp, "bulletin/writeBulletin.tiles");
		
	}

}
