package newb;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CommandList implements Command{

	@Override
	public void action(HttpServletRequest req, HttpServletResponse resp) {
		DAO dao=DAO.getInstance();
		String tempPage=req.getParameter("pageNum");
		int pageNum=1;
		if(tempPage!=null) {
			pageNum=Integer.parseInt(tempPage);
		}
		List<DTO> list=dao.list(pageNum-1,null,null);
		req.setAttribute("list",list );
		req.setAttribute("command", "newb.jsp");
		int temp=dao.count();
		int block=(pageNum-1)/10;
		temp-=block*100;
		System.out.println(temp);
		int pageQ=temp/10;
		if(temp%10!=0) {
			pageQ+=1;
		}
		if(pageQ>10)pageQ=10;
		int pageStart=(((pageNum-1)/10)+1)*10-9;
		System.out.println((((pageNum-1)/10)+1)*10-9);
		System.out.println("pagestart:"+pageStart);
		System.out.println("pageQ :"+pageQ);
		req.setAttribute("pageStart",pageStart);
		req.setAttribute("pageQ",pageQ);
	}
	
}	
