package net.antra.deptemp.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtility {
	final static String DB_URL = "jdbc:mysql://localhost/dept_emp_proj";
	final static String USER = "root";
	final static String PASS = "123456";

	public static Connection getConnection() throws SQLException{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
		return conn;
	}
}
