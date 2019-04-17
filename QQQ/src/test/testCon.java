package test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/testCon")
public class testCon extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public testCon() {
    	System.out.println("testCon");
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DTO> list=DAO.getInstance().getList();
		System.out.println(list);
		request.setAttribute("list", list);
		request.getRequestDispatcher("/testw/NewFile.jsp").forward(request, response);;
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
