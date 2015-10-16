package lulu.lulu;

import java.io.IOException;
//import java.util.HashMap;
//import java.util.Map;

import java.sql.*;

import lulu.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lulu.model.LoginUser;
import net.sf.json.*;

//import DefualtPrintOut;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
//		response.setContentType(null);
		
		String username = (String) DefualtPrintOut.defaultGetStr("username",request);//(String)request.getParameter("username");
		String vcode = (String) DefualtPrintOut.defaultGetStr("vcode",request);//(String)request.getParameter("vcode");
		
//		DefualtPrintOut.defaultPrint(username + "," + vcode, response);
		
		if(username == null || vcode == null)
		{
			DefualtPrintOut.printError(1, response);
		}else{
			LoginUser user = new LoginUser();
			
			JSONObject result = new JSONObject();
			result.put("code",1);
			result.put("result","");
			
			
			Connection connection = DB.getConn();
			String sql = "select * from user where username=?";
			PreparedStatement statement = DB.getPStmt(connection, sql, new Object[]{username});
			ResultSet rs = null;
			try {
				rs = statement.executeQuery();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				DB.close(rs);
				rs = null;
				DB.close(statement);
				statement = null;
				DB.close(connection);
				connection = null;
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
					
					String token = "fhjdkkdjshfkdsj";
					user.setToken(token);
					String updateSql = "update user set token='" + token + "' where id=" + user.getID();
					
					statement.executeUpdate(updateSql);
					
					result.put("user", user);
					
				}else{
					result.put("code", 0);
					result.put("result","用户不存在");
				}
				
				DefualtPrintOut.defaultPrint(result.toString(), response);
				
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
			
//			userJson.put("ID",user.getID());
			
//			DefualtPrintOut.defaultPrint(result.toString(), response);
			
		}
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
