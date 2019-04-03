package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class DBCP {
	public static Connection getConn(){
		Connection conn=null;
		Context ic;
		try {
			ic = new InitialContext();
			Context env=(Context) ic.lookup("java:/comp/env");
			DataSource ds=(DataSource) env.lookup("jdbc/myoracle");
			conn=ds.getConnection();
		} catch (NamingException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
