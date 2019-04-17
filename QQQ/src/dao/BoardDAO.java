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
	
	public Connection conn=MyDBConn.getConn();
	public PreparedStatement pstmt=null;
	public ResultSet rs=null;
	
	static private BoardDAO instance;
	
	public static BoardDAO getInstance() {
		if(instance == null) instance = new BoardDAO();
		return instance;
	}
	
	public List<BoardDTO> boardList(){
		List<BoardDTO> list=new ArrayList<>();
		
		try {
			String sql="select * from board";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				BoardDTO dto=new BoardDTO(rs.getInt("id"),rs.getString("writer"),rs.getString("title"),rs.getString("content"), rs.getString("mail"));
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

	
	public BoardDTO getBoardById(int id) {
		BoardDTO boardById = null;
		String sql = "select * from board where id=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int i = 0;
				boardById = new BoardDTO();
				boardById.setId(rs.getInt(++i));
				boardById.setWriter(rs.getString(++i));
				boardById.setTitle(rs.getString(++i));
				boardById.setContent(rs.getString(++i));
				boardById.setMail(rs.getString(++i));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return boardById;
	}
	
	public int insertBoard(BoardDTO board) {
		String sql = "INSERT INTO board(writer, title, content, mail) values(?, ?, ?, ?)";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, board.getWriter());
			pstmt.setString(2, board.getTitle());
			pstmt.setString(3, board.getContent());
			pstmt.setString(4, board.getMail());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
