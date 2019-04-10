package newb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandDelete implements Command {

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		String s="idx";
		DTO dto=DAO.getInstance().serch(Integer.parseInt(req.getParameter("idx")));
		if(dto.getIdx()==(dto.getRefg()))
			s="refg";
		DAO.getInstance().delete(s, Integer.parseInt(req.getParameter("idx")));
		req.setAttribute("command", "list.co");
		req.setAttribute("send", "dd");
	}

}
