package test;

import java.sql.Connection;
import java.util.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAO {
	private static DAO instance=new DAO();
	private DAO() {}
	public static DAO getInstance() {
		return instance;
	}
	
	private  Connection getConnection() {
		String url="jdbc:oracle:thin:@localhost:1521:orcl";
		String user="test";
		String pass="test";
		Connection conn=null;
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn=DriverManager.getConnection(url,user,pass);
		}catch(SQLException | ClassNotFoundException e) {
			e.printStackTrace();
		}finally {
			
		}
		return conn;
	}
	public List<DTO> getList() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<DTO> list=new ArrayList<>();
		
		try {
			String sql="select * from testem";
			conn=getConnection();
			pstmt=conn.prepareStatement(sql);
			pstmt.execute();
			rs=pstmt.getResultSet();
			
			while(rs.next()) {
				int id=rs.getInt("id");
				Date date=rs.getDate("day");
				String content=rs.getString("content");
				DTO dto=new DTO(id,date,content);
				list.add(dto);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
}
