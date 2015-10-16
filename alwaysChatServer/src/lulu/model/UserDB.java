package lulu.model;

import lulu.sql.*;

import java.sql.*;

public class UserDB {
	
	public static Object getLoginUser(long ID,String token){
		
		LoginUser user = new LoginUser();
		
		Connection connection = DB.getConn();
		PreparedStatement statement = DB.getPStmt(connection, "select * from user where id=?", new Object[]{ID});
		ResultSet rs = null;
		try {
			rs = statement.executeQuery();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
			
			
		}finally
		{
			DB.close(rs);
			rs = null;
			DB.close(statement);
			statement = null;
			DB.close(connection);
			connection = null;
		}
		
		
		return null;
		
	}
	
}
