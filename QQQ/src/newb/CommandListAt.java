package newb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandListAt implements Command {

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		DAO dao=DAO.getInstance();
		dao.upViews(Integer.parseInt(req.getParameter("idx")));
		DTO dto=dao.serch(Integer.parseInt(req.getParameter("idx")));
		req.setAttribute("dto",dto );
		req.setAttribute("command","/newb/detail.jsp");
		
	}

}
