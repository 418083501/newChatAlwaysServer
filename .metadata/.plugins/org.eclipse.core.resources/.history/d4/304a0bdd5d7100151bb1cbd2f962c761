package lulu.sql;
import java.sql.*;
public class DB {
	public static Connection getConn(){
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/alwaysChat","root","");
//			System.out.println("”–¡À ");
			/*Class.forName("com.mysql.jdbc.Driver");
	    	String url = "jdbc:mysql://localhost/bbs?user=root&password=aaaaaa";
			conn = DriverManager.getConnection(url);*/
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			
			System.out.println("a");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("b");
		}
		return conn;
    	
	}
	public static Statement getStmt(Connection conn){
		Statement stmt = null;
		try {
			stmt = conn.createStatement();
//			System.out.println("≈∂¡À");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("stmt");
		}
		return stmt;
	}
	public static ResultSet executeQuery(Statement stmt,String sql){
		ResultSet rs = null;
		try {
			rs = stmt.executeQuery(sql);
			//System.out.println("ø…¿÷");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}
	public static void close(Connection conn){
		if(conn != null){
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = null;
		}
	}
	public static void close(Statement stmt){
		if(stmt != null){
			try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			stmt = null;
		}
	}
	public static void close(ResultSet rs){
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			rs = null;
		}
	}
}
