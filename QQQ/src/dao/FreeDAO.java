package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.FreeDTO;
import util.MyDBConn;

public class FreeDAO {
	public List<FreeDTO> freeList(int ref) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<FreeDTO> list=new ArrayList<>();
		try {
			String sql="select * from free where reff=?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, ref);
			pstmt.execute();
			rs=pstmt.getResultSet();
			while(rs.next()) {
				boolean b=false;
				int i=rs.getInt("reply");
				if(i==1) {
					b=true;
				}
				FreeDTO dto=new FreeDTO(rs.getInt("idx"),rs.getInt("reff"),rs.getInt("seq"),rs.getString("author"),rs.getString("content"),b);
				
				list.add(dto);
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
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
		return list;
	}
	
	public int freeInsert(FreeDTO dto) {
		
		return 0;
		
	}
}
