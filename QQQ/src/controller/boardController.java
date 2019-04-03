package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDAO;

public class boardController extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int i=req.getRequestURI().indexOf("?");
		String s=null;
		if(i>=0) {
			
			s=req.getRequestURI().substring(req.getContextPath().length(),i);
		}else {
			s=req.getRequestURI().substring(req.getContextPath().length());
		}
		if(s.equals("/board/list")) {
			boardList(req,resp);
		}else if(s.equals("/board/write")) {
			boardWrite(req,resp);
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
	
	private void boardList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list",new BoardDAO().boardList());
		req.getRequestDispatcher("/board.jsp").forward(req,resp);
	}
	private void boardWrite(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/boardWrite.jsp").forward(req,resp);
	}
}
