package newb;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandInsert implements Command{

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("MS949");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String author=req.getParameter("author");
		String content=req.getParameter("content");
		String title=req.getParameter("title");
		
		DAO dao=DAO.getInstance();
		String param=req.getParameter("idx");
		int idx=0;
		System.out.println(param);
		if(param!=null&&param!="") {
			idx=Integer.parseInt(param);
		}
		System.out.println(idx);
		int nextval=dao.nextVal();
		DTO dto=dao.serch(idx);
		if(dto!=null) {
			dao.seqSort(dto.getRefg(), dto.getSeq());
			dao.insert(new DTO(nextval,dto.getRefg(),dto.getSeq()+1,dto.getLev()+1,author,content,title,0));
			
		}else {
			
			
				dao.insert(new DTO(nextval,nextval,1,1,author,content,title,0));
			
			
			
		}
		req.setAttribute("command","list.co");
		req.setAttribute("send","dd");
	}
	
}
