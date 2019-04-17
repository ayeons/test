package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import dto.ProductDTO;
import util.DBCP;
import util.DBConn;

public class ProductDAO {
	
	public List<ProductDTO> getList(){
		List<ProductDTO> list=new ArrayList<>();
		Connection conn=DBConn.getConn();
		PreparedStatement stmt=null;
		
		ResultSet rs=null;
		String sql="select * from product";
		
		try {
			stmt=conn.prepareStatement(sql);
			
			stmt.executeUpdate();
			
			
			rs=stmt.getResultSet();
			while(rs.next()) {
				String productId=rs.getString("productId");
				String productName=rs.getString("productName");
				int price=rs.getInt("price");
				String imageName=rs.getString("imageName");
				String description=rs.getString("description");
				list.add(new ProductDTO(productId,productName,price,imageName,description));
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(stmt!=null)
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
		}
		return list;
		
	}
	
	public ProductDTO productSearch(String id) {
		Connection conn=DBConn.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		ProductDTO dto=null;
		try {
			String sql="select * from product where productid=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto=new ProductDTO(
					
						rs.getString("productId"),
						rs.getString("productName"),
						rs.getInt("price"),
						rs.getString("imageName"),
						rs.getString("description")
						);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return dto;
		
	}
	
	public int productInsert(ProductDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			String sql="insert into product values(?,?,?,?,?)";
			conn=DriverManager.getConnection("jdbc:apache:commons:dbcp:/pool");
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,dto.getProductId());
			pstmt.setString(2,dto.getProductName());
			pstmt.setInt(3,dto.getPrice());
			pstmt.setString(4, dto.getImageName());
			pstmt.setString(5, dto.getDescription());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
	public int productUpdate(ProductDTO dto) {
		Connection conn=DBCP.getConn();
		PreparedStatement pstmt=null;
		int result=0;
		try {
			
			String sql="update product set productName=?,price=?,imagename=?,description=? where productid=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getProductName() );
			pstmt.setInt(2,dto.getPrice());
			pstmt.setString(3,dto.getImageName() );
			pstmt.setString(4,dto.getDescription() );
			pstmt.setString(5, dto.getProductId());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
		
	}
	
	public int productDelete(String id) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			String sql="delete from product where productid=?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,id);
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally{
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		return result;
	}
}
