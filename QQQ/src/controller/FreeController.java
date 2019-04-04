package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.FreeDAO;
import dto.FreeDTO;


public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public FreeController() {
    	
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getRequestURI().substring(request.getContextPath().length());
		if(s.indexOf("?")>=0) {
			s=s.substring(0,s.indexOf("?"));
		}
		if(s.equals("/free/list")) {
			List<FreeDTO> list=list(Integer.parseInt(request.getParameter("reff")));
					  request.setAttribute("list",list);
					  
					  request.getRequestDispatcher("/freeBoard.jsp").forward(request,response);
		}else if(s.equals("/free/ajax")) {
			List<FreeDTO> list=list(Integer.parseInt(request.getParameter("reff")));
					  request.setAttribute("list",list);
					  PrintWriter out=response.getWriter();
					 
					 
					  
					  	out.println("<a>");
					  for(FreeDTO dto:list) {
						  out.println("<idx>");
						  out.println(dto.getIdx());
						  out.println("</idx>");
						  out.println("<reff>");
						  out.println(dto.getReff());
						  out.println("</reff>");
						  out.println("<seq>");
						  out.println(dto.getSeq());
						  out.println("</seq>");
						  out.println("<author>");
						  out.println(dto.getAuthor());
						  out.println("</author>");
						  out.println("<content>");
						  out.println(dto.getContent());
						  out.println("</content>");
					  }
					  out.println("</a>");
					  
		}
		
		  
		 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	public List<FreeDTO> list(int reff){
		return new FreeDAO().freeList(reff);
	}
}
