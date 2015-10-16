package lulu.lulu;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;
import lulu.model.*;
import lulu.sql.DB;

/**
 * Servlet implementation class GetBasicUser
 */
@WebServlet("/GetBasicUser")
public class GetBasicUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBasicUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String uid = (String) DefualtPrintOut.defaultGetStr("uid",request);//defaultGetStr
		String token = (String) DefualtPrintOut.defaultGetStr("token",request);
		String ids = (String) DefualtPrintOut.defaultGetStr("ids",request);//request.getParameter("ids");
		
		LoginUser user = (LoginUser) UserDB.getLoginUser(Long.parseLong(uid), token);
		
		
		System.out.println("uid="+uid+",token="+token+",ids="+ids);
		
		if(ids == null || uid == null || token == null){
			
			DefualtPrintOut.printError(1, response);
			return;
			
		}
		
		uid = null;
		
		if(ids.replace("admin", "").equals("")){
			
			DefualtPrintOut.printError(1, response);
			
			return;
		}
		
		if(token.equals(user.getToken())){
			
			String idArray[] = ids.split(",");
			LinkedList<String> idList = new LinkedList<String>();
			for(int i = 0;i<idArray.length;i++){
				try{
					if(Long.parseLong(idArray[i]) == 0){
						continue;
					}
				}catch(Exception e){
					continue;
				}
				idList.add(idArray[i]);
			}
			
			idArray = (String[]) idList.toArray(new String[0]);
			idList = null;
			ids = null;
			if(idArray.length > 0){
				
				Connection connection = DB.getConn();
				Statement statement = DB.getStmt(connection);
				String sql = "select id,name,sex,facePath,location,destrib from user where id in(";
				
				for(int i = 0;i<idArray.length;i++){
					
					try{
						if(Long.parseLong(idArray[i]) == 0){
							continue;
						}
					}catch(Exception e){
						continue;
					}
					
					sql += idArray[i];
					if(idArray.length != i + 1){
						sql += ",";
					}
					
				}
				
				sql += ")";
				
				System.out.println("sql=" + sql);
				idArray = null;
				
				LinkedList<BaseUser> list = new LinkedList<BaseUser>();
				
				ResultSet rs = DB.executeQuery(statement, sql);
				if(rs == null){
					
					DefualtPrintOut.printError(4, response);
					
					return;
					
				}
				try {
					while(rs.next()){
						
						BaseUser baseUser = new BaseUser();
						baseUser.setID(rs.getLong("id"));
						baseUser.setName(rs.getString("name"));
						baseUser.setSex(rs.getString("sex"));
						baseUser.setFacePath(rs.getString("facePath"));
						baseUser.setLocation(rs.getString("location"));
						baseUser.setDestrib(rs.getString("destrib"));
						
						list.add(baseUser);
						baseUser = null;
						
					}
					
					JSONObject result = new JSONObject();
					result.put("code",1);
					result.put("result","");
					
					result.put("data", list);
					
					DefualtPrintOut.defaultPrint(result.toString(), response);
					
					list = null;
					
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
				
			}else{
				
				DefualtPrintOut.printError(1, response);
			}
			
		}else{
			DefualtPrintOut.printError(3, response);
		}
		
		token = null;
		user = null;
	}

}
