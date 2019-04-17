package newb;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandUpdate implements Command {

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		int idx=Integer.parseInt(req.getParameter("idx"));
		String content=req.getParameter("content");
		String title=req.getParameter("title");
		
		DAO dao=DAO.getInstance();
		DTO dto=dao.serch(idx);
		int result=dao.update(new DTO(idx,dto.getRefg(),dto.getSeq(),dto.getLev(),dto.getAuthor(),content,title,dto.getViews()));
		req.setAttribute("result", result);
		req.setAttribute("send", "dd");
		req.setAttribute("command", "/QQQ/newb/list.co");
	}

}
