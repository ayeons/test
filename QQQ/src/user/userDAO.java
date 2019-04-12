package user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import util.MyDBConn;



public class userDAO {
		
	

	public int registerCheck(String userID) {
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String SQL = " select * from user where userID = ? ";
		try {
			conn=MyDBConn.getConn();
			pstmt = conn.prepareStatement(SQL);
			pstmt.setString(1, userID);
			rs = pstmt.executeQuery();
			if(rs.next() || userID.equals("")) {
				return 0; // 이미 존재하는 회원
			}
			else {
				return 1; // 가입 가능한 회원 아이디
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
		return -1; //데이터베이스 오류
	}
	public int register(String usersID, String userPassword, String userName, String userAge, String userGender, String userEmail) {
			Connection conn=null;
			PreparedStatement pstmt = null;
			
			String SQL = "insert into user values(?, ?, ?, ?, ?, ?)";
			try {
				conn=MyDBConn.getConn();
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
			return -1; //데이터베이스 오류
		}
		
	}

	

