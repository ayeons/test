package controller;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import util.DBCP;

public class MemberController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		HashMap<String,Object> map=new HashMap<>();
		FileInputStream fis=null;
		Properties prob=new Properties();
		String s=config.getInitParameter("path");
		String realPath=config.getServletContext().getRealPath("WEB-INF/classes/prob");
		try {
			fis=new FileInputStream(realPath);
			prob.load(fis);
			Enumeration<?> e=prob.keys();
			while(e.hasMoreElements()) {
				String key=(String) e.nextElement();
				String value=prob.getProperty(key);
				map.put(key,value);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		load(req,resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
		
		
	}
	
	public void load(HttpServletRequest req,HttpServletResponse resp) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		FileInputStream fis=null;
		try {
			String sql="select * from test2";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			/*
			 * fis=new FileInputStream("c:/ttt/image.jpg"); pstmt.setBlob(1, fis);
			 */
			rs=pstmt.executeQuery();
			if(rs.next()) {
				Blob b=rs.getBlob(1);
				req.setAttribute("image", b);
				InputStream fis2=b.getBinaryStream();
				BufferedOutputStream fos=new BufferedOutputStream(resp.getOutputStream());
				byte[] bytes=new byte[100];
				int i=0;
				while((i=fis2.read(bytes))!=-1) {
					fos.write(bytes);
					
				}
				fos.close();
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			
			
		}
	}
}
