package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import dto.FreeDTO;

public class FreeServiceAjax implements FreeServiceable {
	
	@Override
	public void list(HttpServletRequest req, HttpServletResponse resp) {
		int refg=Integer.parseInt(req.getParameter("refg"));
		int lev=Integer.parseInt(req.getParameter("lev"));
		
		
		List<FreeDTO> list=FreeDAO.getDAO().reply(refg,lev);
		if(list==null)return;
		resp.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out=resp.getWriter()) {
			
			out.println("<page>");
			for(FreeDTO dto:list) {
				System.out.println(dto.getContent());
				out.println("<item>");
				
				out.println("<idx>");
				out.println(dto.getIdx());
				out.println("</idx>");

				out.println("<author>");
				out.println(dto.getAuthor());
				out.println("</authro>");
				
				out.println("<content>");
				out.println(dto.getContent());
				out.println("</content>");
				
				out.println("<lev>");
				out.println(dto.getLev());
				out.println("</lev>");
				
				out.println("</item>");
			}
			out.println("</page>");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
