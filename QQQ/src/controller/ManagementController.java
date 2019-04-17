package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import dao.ProductDAO;
import dto.ProductDTO;
import service.ManagementService;

@WebServlet("/management/*")
		
public class ManagementController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
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
		if(s.equals("/management/management_insert.jsp")) {
			response.sendRedirect("/QQQ/managementJ/management_insert.jsp");
			
		}
		else if(s.equals("/management/out")) {
			request.getSession().removeAttribute("manage");
			System.out.println(request.getSession().getAttribute("manage"));
			response.sendRedirect("/QQQ/index.jsp");
		}
		else if(s.equals("/management/insert")) {
			
			String path=request.getServletContext().getRealPath("/resource/img/");
			MultipartRequest mulre=new MultipartRequest(request,path,5000000,"EUC-KR", new DefaultFileRenamePolicy());
			
			String id=mulre.getParameter("productId");
			String name=mulre.getParameter("productName");
			
			int price=Integer.parseInt(mulre.getParameter("price"));
			String imageName=mulre.getFilesystemName("file1");
			String description=mulre.getParameter("description");
			
			int result=new ManagementService().addProduct(new ProductDTO(id,name,price,imageName,description));
			
			request.setAttribute("result", result);
			request.getRequestDispatcher("/managementJ/management_insert_ok.jsp").forward(request, response);;
			
			
		}else if(s.equals("/management/list")) {
			List<ProductDTO> list=new ProductDAO().getList();
			System.out.println(list);
			request.getSession().setAttribute("manage", "ok");
			request.setAttribute("dtoList", list);
			request.getRequestDispatcher("/managementJ/management.jsp").forward(request, response);
		}else if(s.equals("/management/update")) {
			System.out.println("update");
			System.out.println(request.getParameter("productName"));
			String id=request.getParameter("id");
			ProductDTO dto=new ProductDAO().productSearch(id);
			request.setAttribute("dto", dto);
			request.getRequestDispatcher("/managementJ/management_update.jsp").forward(request, response);
		}else if(s.equals("/management/update_ok")) {
			
			
			String path=request.getServletContext().getRealPath("resource/img/");
			MultipartRequest mulre=new MultipartRequest(request, path,500000,"MS949",new DefaultFileRenamePolicy());
			
			String id=mulre.getParameter("productId");
			String name=mulre.getParameter("productName");
			
			String price=mulre.getParameter("price");
			
			String description=mulre.getParameter("description");
			ProductDTO dto=new ProductDTO(id,name,Integer.parseInt(price),description);
			
			if(mulre.getFilesystemName("file1")!=null){
				
				String imageName=mulre.getFilesystemName("file1");
				dto.setImageName(imageName);
			}
			
			
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
