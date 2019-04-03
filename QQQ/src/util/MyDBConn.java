package util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class MyDBConn {
	
	public static Connection getConn() {
		Context init;
		Context env;
		DataSource ds;
		try {
			init = new InitialContext();
			env=(Context) init.lookup("java:/comp/env");
			ds=(DataSource) env.lookup("jdbc/mysql");
			return ds.getConnection();
		} catch (NamingException|SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}
