package user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import util.DBCP;
import util.MyDBConn;



public class userDAO {
		
	

	public int registerCheck(String userID) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = " select * from uuser where userID = ? ";
		try {
			conn=DBCP.getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next() || userID.equals("")) {
				return 0; 
			}
			else {
				return 1; 
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn!=null)conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return -1; 
	}
	public int register(String usersID, String userPassword, String userName, String userAge, String userGender, String userEmail) {
			Connection conn=null;
			PreparedStatement pstmt = null;
			
			String SQL = "insert into uuser values(?, ?, ?, ?, ?, ?)";
			try {
				conn=DBCP.getConn();
				pstmt = conn.prepareStatement(SQL);
				pstmt.setString(1, usersID);
				pstmt.setString(2, userPassword);
				pstmt.setString(3, userName);
				pstmt.setInt(4, Integer.parseInt(userAge));
				pstmt.setString(5, userGender);
				pstmt.setString(6, userEmail);
				int result= pstmt.executeUpdate();
				return result;
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					
					if(pstmt != null) pstmt.close();
					if(conn!=null)conn.close();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			return -1; 
	}
	
	public int update(userDTO dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			String sql="update uuser set username=?,userage=?,usergender=?,useremail=? where userid=?";
			
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, dto.getUserName());
			pstmt.setInt(2, dto.getUserAge());
			pstmt.setString(3, dto.getUserGender());
			pstmt.setString(4, dto.getUserEmail());
			pstmt.setString(5, dto.getUserID());
			result=pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn!=null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if(pstmt!=null)
				try {
					pstmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		
		return result;
		
	}
	public userDTO check(String id,String password) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		try {
			String sql="select * from uuser where userid=? and userpassword=?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String uid=rs.getString("userid");
				String pass=rs.getString("userpassword");
				String name=rs.getString("username");
				int age=rs.getInt("userage");
				String gen=rs.getString("usergender");
				String email=rs.getString("userEmail");
				return new userDTO(uid,pass,name,age,gen,email);
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
		return null;
		
	}
	public userDTO serch(String id) {
		String sql="select * from uuser where userid=?";
		ResultSet rs=null;
		userDTO dto=null;
		try(Connection conn=DBCP.getConn(); PreparedStatement pstmt=conn.prepareStatement(sql)){
			pstmt.setString(1, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				String idx=rs.getString("userid");
				
				String name=rs.getString("username");
				int age=rs.getInt("userage");
				String gender=rs.getString("usergender");
				String email=rs.getString("useremail");
				dto=new  userDTO(idx,null,name,age,gender,email);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return dto;
		
	}
}

	

