package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.ProductDAO;
import dto.ProductDTO;
import util.DBConn;

public class ProductController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("post");
		doGet(req,resp);
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 System.out.println(req.getRequestURI());
			int i=req.getRequestURI().indexOf("?");
			String s=null;
			if(!(i<0))s=req.getRequestURI().substring(req.getContextPath().length(),req.getRequestURI().indexOf("?"));
			
			else {
				
				s=req.getRequestURI().substring(req.getContextPath().length());
			}
			 System.out.println(req.getRequestURI());
		  System.out.println("productController"); 
		  if(s.equals("/product/list"))
			  productList(req,resp); 
		  else if(s.equals("/product/addShoppingBasket")){
			  System.out.println(req.getParameter("id"));
			  addShoppingBasket(req,resp);
		  }else if(s.equals("/product/showCart")) {
			  showCart(req,resp);
		  }else if(s.equals("/product/detail")) {
			  detail(req,resp);
		  }else if(s.equals("/product/order")) {
			  order(req,resp);
		  }else if(s.equals("/product/orderProcess")){
			  orderProcess(req,resp);
		  }
		 
		
	}

	


	@Override
	public void destroy() {
		System.out.println("dest");
		try {
			DBConn.getConn().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void init() throws ServletException {
		
	}
	public void productList(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("methodproductList");
		List<ProductDTO> list=new ProductDAO().getList();
		req.setAttribute("dtoList", list);
		
		
		RequestDispatcher rd=req.getRequestDispatcher("/productList.jsp");
		
		rd.forward(req,resp);
	}
	
	public void addShoppingBasket(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
		 HttpSession s=req.getSession();
		 System.out.println("addShopping");
		 int count=0;
		if(s.getAttribute("shoppingList")==null) {
			s.setAttribute("shoppingList", new ArrayList<ProductDTO>());
			System.out.println("newlist");
		}
		List<ProductDTO> list=(List<ProductDTO>)s.getAttribute("shoppingList");
		ProductDAO dao=new ProductDAO();
		System.out.println(req.getParameter("id"));
		
		ProductDTO dto=dao.productSearch(req.getParameter("id"));
		System.out.println(list.size());
		System.out.println(dto);
		if(dto==null)return;
		
		if(list.size()==0) {
			list.add(dto);
		}
		else {
			
			for(ProductDTO d:list) {
				
				if(d.getProductId().equals(dto.getProductId())) {
					
					d.setQuantity(d.getQuantity()+1);
					count++;
				}
			}
			if(count==0)
				list.add(dto);
			
		}
		
		req.getRequestDispatcher("/addShoppingBasket").forward(req, resp);
	}
	
	public void showCart(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session=req.getSession();
		
		System.out.println("showCart");
		List<ProductDTO> list=(List<ProductDTO>)session.getAttribute("shoppingList");
		
		req.setAttribute("list",list);
		req.getRequestDispatcher("/showCart.jsp").forward(req,resp);
		
		
	}
	private void detail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("detail");
		ProductDAO dao=new ProductDAO();
		String id=req.getParameter("id");
		
		ProductDTO dto=dao.productSearch(id);
		req.setAttribute("dto", dto);
		req.getRequestDispatcher("/detail.jsp").forward(req, resp);
	}
	
	private void order(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie[] coo=req.getCookies();
		
		for(Cookie c:coo) {
			String s=c.getName();
			System.out.println(s);
			if(s.equals("address")) {
				req.setAttribute("address", c.getValue());			}
			if(s.equals("name")) {
				req.setAttribute("name",c.getValue());
			}
		}
		req.getRequestDispatcher("/order.jsp").forward(req, resp);
	}
	

	private void orderProcess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Cookie nameCoo=new Cookie("name",req.getParameter("name"));
		Cookie addressCoo=new Cookie("address",req.getParameter("address"));
		nameCoo.setMaxAge(60*5);
		addressCoo.setMaxAge(60*5);
		resp.addCookie(nameCoo);
		resp.addCookie(addressCoo);
		req.getRequestDispatcher("/orderProcess.jsp").forward(req, resp);
		
	}
	
	
}
