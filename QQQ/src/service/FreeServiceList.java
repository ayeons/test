package service;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import dto.FreeDTO;

public class FreeServiceList implements FreeServiceable{
	@Override
	public void list(HttpServletRequest req,HttpServletResponse resp){
		int i=FreeDAO.getDAO().freeQuantity(0);
		String s=req.getParameter("pageNum");
		int pageNum=1;
		if(s!=null)
			pageNum=Integer.parseInt(s);
		List<FreeDTO> list=FreeDAO.getDAO().freeList(pageNum,10,i);
		int Quantity=0;		
		if(i%10==0) {
			
			Quantity=i/10;  
		}else {
			Quantity=i/10+1;
		}
		
			  req.setAttribute("list",list);
			  req.setAttribute("pageQuantity", Quantity);
			  RequestDispatcher rd=req.getRequestDispatcher("/freeJ/freeBoard.jsp");
				try {
					rd.forward(req, resp);
				} catch (ServletException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
	}
}
