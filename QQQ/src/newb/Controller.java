package newb;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("*.co")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	HashMap<String,Command> map;
    public Controller() {
    	loadPro("newb/resource");
    	
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void loadPro(String path) {
			map=new HashMap<>();
		  ResourceBundle rb=ResourceBundle.getBundle(path); System.out.println("load");
		  Enumeration<?> e=rb.getKeys();
		  while(e.hasMoreElements()) {
			  String requestPath=(String) e.nextElement();
			  String className=rb.getString(requestPath);
			  
			  try {
				Class<?> cla=Class.forName(className);
				Command com=(Command) cla.newInstance();
				map.put(requestPath,com);
			} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
			  
		  }
		
	}
	
	public void doProcess(HttpServletRequest req,HttpServletResponse resp) {
		try {
			req.setCharacterEncoding("MS949");
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		String uri=req.getRequestURI();
		String path=uri.substring(uri.lastIndexOf("/"));
		System.out.println(uri);
		System.out.println(path);
		Command com=map.get(path);
		if(com==null) {
			System.out.println("잘못된요청");
			return;
		}
		com.action(req, resp);
		String forwardPath=(String) req.getAttribute("command");
		if(req.getAttribute("send")!=null) {
			try {
				resp.sendRedirect(forwardPath);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			
			try {
				req.getRequestDispatcher(forwardPath).forward(req,resp);
			} catch (ServletException | IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("after send forward");
	}
	
	
}
