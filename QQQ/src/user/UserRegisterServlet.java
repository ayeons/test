package user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/userRegister")
public class UserRegisterServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String userID = request.getParameter("userID");
		String userPassword1 = request.getParameter("userPassword1");
		String userPassword2 = request.getParameter("userPassword2");
		String userName = request.getParameter("userName");
		String userAge = request.getParameter("userAge");
		String userGender = request.getParameter("userGender");
		String userEmail = request.getParameter("userEmail");
		if(userID == null || userID.equals("") || userPassword1 == null || userPassword1.equals("")
		|| userPassword2 == null || userPassword2.equals("") || userName == null || userName.equals("")
		|| userAge == null || userAge.equals("") || userGender == null || userGender.equals("")
		|| userEmail == null || userEmail.equals("") ) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요.");
			response.sendRedirect("/QQQ/sign/signUp.jsp");
			return;
		}
		if(!userPassword1.equals(userPassword2)) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "모든 내용을 입력하세요.");
			response.sendRedirect("/QQQ/sign/signUp.jsp");
			return;
		}
		int result = new userDAO().register(userID, userPassword1, userName, userAge, userGender, userEmail );
		if(result == 1) {
			request.getSession().setAttribute("messageType", "회원가입");
			request.getSession().setAttribute("messageContent", "축하합니다.");
			response.sendRedirect("/QQQ/sign/insertOK.jsp");
			return;
		}
		if(result != 1) {
			request.getSession().setAttribute("messageType", "오류 메시지");
			request.getSession().setAttribute("messageContent", "이미 존재하는 회원입니다.");
			response.sendRedirect("/QQQ/sign/signUp.jsp");
			return;
		}
	}
}
