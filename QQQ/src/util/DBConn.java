package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	private static Connection conn;
	private DBConn() {}
	public static Connection getConn() {
		if(conn==null) {
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				System.out.println("driverload");
				conn=DriverManager.getConnection("jdbc:oracle:thin:@192.168.10.50:1521:orcl","test","test");
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
		
		return conn;
	}
	
	
}
