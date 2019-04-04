package test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(initParams={
	@WebInitParam(name="probPath",value="/test/prob")
}, urlPatterns= {"/test/*"})
public class cont extends HttpServlet{
	Map<String,Inter> map=new HashMap<>();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String requestPath=req.getRequestURI().substring(req.getContextPath().length());
		
		Inter inter=map.get(requestPath);
		if(inter==null)System.out.println("fdfd");
		else {
			
			inter.action();
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}

	
	

	@Override
	public void init() throws ServletException {
		System.out.println("init");
		Properties prob=new Properties();
		FileInputStream fis=null;
		String probPath=getInitParameter("probPath");
		String probReal=getServletContext().getRealPath("/WEB-INF/classes")+probPath;
		try {
			fis=new FileInputStream(probReal);
			prob.load(fis);
			Enumeration<?> e=prob.keys();
			while(e.hasMoreElements()) {
				String requestPath=(String)e.nextElement();
				String classPath=prob.getProperty(requestPath);
				Class<?> cl=Class.forName(classPath);
				Inter inter=(Inter) cl.newInstance();
				map.put(requestPath, inter);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	

	
}
