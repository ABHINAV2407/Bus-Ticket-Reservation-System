package Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
    
public static Connection preConnection() {
		
		Connection conn = null;
		
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		String url = "jdbc:mysql://localhost:3306/BTR";
		
		try {
			
			conn= DriverManager.getConnection(url,"root","662626611");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		
		
		return conn;
		
	}

	
}
