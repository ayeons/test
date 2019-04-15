package user;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user/*")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String,UserInter> map=new HashMap<>();
	
    public UserController() {
    	
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String requestPath=request.getRequestURI().substring(request.getServletContext().getContextPath().length());
		 System.out.println(requestPath);
		 if(requestPath.equals("/user/updateOK")) {
			 new userDAO().update(makeDTO(request,response));
			 response.sendRedirect("/QQQ/index.jsp");
			 return;
		 }
		 if(requestPath.equals("/user/login")) {
			 request.getRequestDispatcher("/sign/login.jsp").forward(request, response);
		 }
		 if(requestPath.equals("/user/logout")) {
			 System.out.println("fd");
			 HttpSession session=request.getSession();
			 session.invalidate();
			 
			 
			 response.sendRedirect("/QQQ/");
		 }
		
		 if(requestPath.equals("/user/sign")) {
			 
			 request.getRequestDispatcher("/sign/signUp.jsp").forward(request,response);
			 return;
		 }
		 if(requestPath.equals("/user/check")) {
			 String id=request.getParameter("userId");
			 String pass=request.getParameter("userPassword");
			 System.out.println(id);
			 userDTO dto=new userDAO().check(id, pass);
			
			 if(dto!=null) {
				 
				 dto.setUserPassword("");
				 request.getSession().setAttribute("memDTO",dto);
				 
				 response.sendRedirect("/QQQ/index.jsp");
			 }else {
				 request.setAttribute("loginMessage", "틀렸다");
				 
				 request.getRequestDispatcher("/user/login").forward(request, response);;
			 }
			 
			 return;
		 }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private userDTO makeDTO(HttpServletRequest req,HttpServletResponse resp) {
		userDTO dto=new userDTO();
		dto.setUserID(req.getParameter("userId"));
		dto.setUserPassword(req.getParameter("userPassword"));
		dto.setUserName(req.getParameter("userName"));
		dto.setUserAge(Integer.parseInt(req.getParameter("userAge")));
		dto.setUserGender(req.getParameter("userGender"));
		dto.setUserEmail(req.getParameter("userEmail"));
		return dto;
	}
	
}
