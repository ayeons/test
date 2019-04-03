package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dto.BoardDTO;
import util.MyDBConn;

public class BoardDAO {
	
	public List<BoardDTO> boardList(){
		List<BoardDTO> list=new ArrayList<>();
		Connection conn=MyDBConn.getConn();
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from board";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO(rs.getInt("id"),rs.getString("author"),rs.getString("title"),rs.getString("content"));
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
}
