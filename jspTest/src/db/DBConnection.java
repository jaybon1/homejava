package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	
	public static Connection getConnection() {
		
		try {
			
			// ojdbc jar파일에서 오라클드라이버 클래스를 불러온다.
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 불러온 클래스를 이용하여 DB에 연결하고 객체를 저장한다. c##madang으로 바꿀것
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "test1", "test1");
			
			// 객체를 리턴한다.
			return conn;
			
		} catch (Exception e) {
			
			System.out.println("DB 연결 실패 : " + e.getMessage());
			
		}
		
		return null;
		
	}
	
	public static void close(Connection conn, PreparedStatement pstmt) {
		try {
			if (conn != null) {
				conn.close();				
			}
			if (pstmt != null) {		
				pstmt.close();
			}
		} catch (Exception e) {
			System.out.println("DB종료시 오류가 발생 : " +e.getMessage());
		}
	}
	
	
	public static void close(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null) {
				conn.close();				
			}
			if (pstmt != null) {		
				pstmt.close();
			}
			if (rs != null) {		
				rs.close();
			}
			
		} catch (Exception e) {
			System.out.println("DB종료시 오류가 발생 : " +e.getMessage());
		}
	}
	
}
