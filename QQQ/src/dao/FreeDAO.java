package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.FreeDTO;
import util.DBCP;

public class FreeDAO {
	
	private FreeDAO() {};
	private static class Hold{
		public static final FreeDAO dao=new FreeDAO();
		
	}
	public static FreeDAO getDAO() {
		return Hold.dao;
	}
	public List<FreeDTO> freeList(int pageNum,int rows,int lastNum) {
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<FreeDTO> list=new ArrayList<>();
		try {
			pageNum-=1;
			System.out.println(lastNum-pageNum*rows);
			int firstNum=lastNum-pageNum*rows;
			int limit=firstNum-rows;
			
			System.out.println(firstNum);
			System.out.println(limit);
			String sql="select * from "
					+ "(select rownum r,free.* from free where lev=0 order by idx desc) where r<=? and r>?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, firstNum);
			pstmt.setInt(2, limit);
			pstmt.execute();
			rs=pstmt.getResultSet();
			while(rs.next()) {
				
				FreeDTO dto=new FreeDTO(
						rs.getInt("idx"),
						rs.getInt("refg"),
						rs.getInt("seq"),
						rs.getInt("lev"),
						rs.getString("author"),
						rs.getString("content"));
				
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
		
		return list;
	}
	
	public int insert(FreeDTO dto) {
		//TODO 
		String sql="insert into free";
		try(Connection conn=DBCP.getConn(); PreparedStatement pstmt=conn.prepareStatement(sql)){
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public List<FreeDTO> reply(int refg, int lev) {
		List<FreeDTO> list=new ArrayList<>();
		String sql="select * from free where refg=? and lev=?";
		ResultSet rs=null;
		try(Connection conn=DBCP.getConn();PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1, refg);
			pstmt.setInt(2, lev+1);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				
				FreeDTO dto=new FreeDTO(
						rs.getInt("idx"),
						rs.getInt("refg"),
						rs.getInt("seq"),
						rs.getInt("lev"),
						rs.getString("author"),
						rs.getString("content"));
				
				list.add(dto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
		
	}
	
	public int freeQuantity(int page) {
		ResultSet rs=null;
		String sql="select count(*) from (select rownum r,free.* from free where lev=0 ) where r>? and r<=?";
		try(Connection conn=DBCP.getConn(); PreparedStatement pstmt=conn.prepareStatement(sql)) {
			pstmt.setInt(1,page);
			pstmt.setInt(2,page+100);
			rs=pstmt.executeQuery();
			rs.next();		
			return rs.getInt(1);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
		
	}
	
	
}
