package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ProductDAO;
import dto.ProductDTO;
import service.ManagementService;

@WebServlet("/management/*")
		
public class ManagementController extends HttpServlet {
	Connection conn;
	PreparedStatement pstmt;
	ResultSet rs;
    public ManagementController() {
    	try {
    		
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Class.forName("org.apache.commons.dbcp.PoolingDriver");
			System.out.println("joclload");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doget");
		String URI=request.getRequestURI();
		int i=URI.indexOf("?");
		int cont=request.getContextPath().length();
		String s=null;
		if(!(i<0)) {
			s=URI.substring(cont,i);
		}else {
			s=URI.substring(cont);
		}
		System.out.println(s);
		if(s.equals("/management/insert")) {
			String id=request.getParameter("productId");
			String name=request.getParameter("productName");
			int price=Integer.parseInt(request.getParameter("price"));
			String imageName=request.getParameter("imageName");
			String description=request.getParameter("description");
			
			int result=new ManagementService().addProduct(new ProductDTO(id,name,price,imageName,description));
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/management_insert_ok.jsp").forward(request, response);;
			
			
		}else if(s.equals("/management/list")) {
			List<ProductDTO> list=new ProductDAO().getList();
			System.out.println(list);
			request.setAttribute("dtoList", list);
			request.getRequestDispatcher("/management.jsp").forward(request, response);
		}else if(s.equals("/management/update")) {
			System.out.println("update");
			String id=request.getParameter("id");
			ProductDTO dto=new ProductDAO().productSearch(id);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/management_update.jsp").forward(request, response);
		}else if(s.equals("/management/update_ok")) {
			String id=request.getParameter("productId");
			String name=request.getParameter("productName");
			String price=request.getParameter("price");
			String imageName=request.getParameter("imageName");
			String description=request.getParameter("description");
			ProductDTO dto=new ProductDTO(id,name,Integer.parseInt(price),imageName,description);
			int result=new ManagementService().updateProduct(dto);
			
			response.sendRedirect("/QQQ/management/list?result="+result);
		}else if(s.equals("/management/delete")) {
			
		
			int result=new ManagementService().deleteProduct(request.getParameter("id"));
			response.sendRedirect("/QQQ/management/list?result="+result);
		}
		
		
		

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
		
	}

}
