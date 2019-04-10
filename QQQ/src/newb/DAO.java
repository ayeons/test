package newb;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import util.DBCP;

public class DAO {
	private static DAO instance=new DAO();
	private DAO() {
		
	}
	public static DAO getInstance() {
		return instance;
	}
	
	public int count() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			String sql="select count(*) from newb";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(Exception e) {
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
		return result;
	}
	
	public List<DTO> list(int pageNum, String opt,String condition) {
		List<DTO> list=new ArrayList<>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs= null;
		StringBuffer sb=new StringBuffer();
		
		
		
		
		try {
			conn=DBCP.getConn();
			if(opt!=null) {
				sb.append("select * from newb order by refg,seq");
				pstmt=conn.prepareStatement(sb.toString());
			}else {
				sb.append("select * from (select rownum r,n.* from (select * from newb order by refg desc,seq) n) where r>? and r<=?");
				pstmt=conn.prepareStatement(sb.toString());
				pstmt.setInt(1,pageNum*10);
				pstmt.setInt(2,pageNum*10+10);
			}
				rs=pstmt.executeQuery();
				while(rs.next()) {
					int idx=rs.getInt("idx");
					int refg=rs.getInt("refg");
					int seq=rs.getInt("seq");
					int lev=rs.getInt("lev");
					String author=rs.getString("author");
					String content=rs.getString("content");
					list.add(new DTO(idx,refg,seq,lev,author,content));
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
		System.out.println(conn==null);
		System.out.println(pstmt==null);
		try {
			System.out.println(conn.isClosed());
			System.out.println(pstmt.isClosed());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public int insert(DTO dto){
		Connection conn=null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			String sql="insert into newb values(?,?,?,?,?,?)";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,dto.getIdx());
			pstmt.setInt(2,dto.getRefg());
			pstmt.setInt(3,dto.getSeq());
			pstmt.setInt(4,dto.getLev());
			pstmt.setString(5,dto.getAuthor());
			pstmt.setString(6,dto.getContent());
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
	
	public int nextVal() {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		int result=0;
		try {
			String sql="select newbseq.nextval from dual";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				result=rs.getInt(1);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
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
		return result;
	}
	
	public DTO serch(int idx) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		DTO dto=null;
		try {
			String sql="select * from newb where idx=?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, idx);
			rs=pstmt.executeQuery();
			if(rs.next()) {
				
				int refg=rs.getInt("refg");
				int seq=rs.getInt("seq");
				int lev=rs.getInt("lev");
				dto=new DTO(idx,refg,seq,lev,null,null);
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			if(rs!=null)
				try {
					rs.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
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
		return dto;
	}
	
	public void seqSort(int refg,int seq) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		try {
			String sql="update newb set seq=seq+1 where refg=? and seq>?";
			conn=DBCP.getConn();
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, refg);
			pstmt.setInt(2, seq);
			pstmt.executeUpdate();
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
		
		
	}
	
	public int delete(String s,int idx) {
		Connection conn= null;
		PreparedStatement pstmt=null;
		int result=0;
		try {
			String sql="delete from newb where "+s+"=?";
			conn=DBCP.getConn();
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1,idx);
			System.out.println(sql);
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
