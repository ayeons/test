package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.FreeDTO;
import service.FreeServiceAjax;
import service.FreeServiceList;
import service.FreeServiceable;


public class FreeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Map<String,FreeServiceable> map=new HashMap<>();
    public FreeController() {
    	System.out.println("constructer");
    	map.put("/free/list",new FreeServiceList());
    	map.put("/free/ajax",new FreeServiceAjax());
    }
    
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String s=request.getRequestURI().substring(request.getContextPath().length());
		if(s.indexOf("?")>=0) {
			s=s.substring(0,s.indexOf("?"));
		}
		System.out.println(s);
		map.get(s).list(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
