package lulu.model;

import lulu.sql.*;

import java.sql.*;

public class UserDB {
	
	public static Object getLoginUser(long ID,String token){
		
		LoginUser user = new LoginUser();
		
		Connection connection = DB.getConn();
		Statement statement = DB.getStmt(connection);
		ResultSet rs = DB.executeQuery(statement, "select * from user where id=" + ID);
		try {
			if(rs.next()){
				user.setUsername(rs.getString("username"));
				user.setID(rs.getLong("id"));
				user.setName(rs.getString("name"));
				user.setSex(rs.getString("sex"));
				user.setFacePath(rs.getString("facePath"));
				user.setLocation(rs.getString("location"));
				user.setDestrib(rs.getString("destrib"));
				user.setToken(rs.getString("token"));
				
				return user;
				
			}else{
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return null;
		
	}
	
}
