package lulu.lulu;

import lulu.model.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class GetUserInfo
 */
@WebServlet("/GetUserInfo")
public class GetUserInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetUserInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String ID = (String) DefualtPrintOut.defaultGetStr("ID",request);//request.getParameter("ID");
		String token = (String) DefualtPrintOut.defaultGetStr("token",request);//request.getParameter("token");
		
		if(ID == null){
			
			DefualtPrintOut.printError(1, response);
			return;
		}
		
		LoginUser user = (LoginUser) UserDB.getLoginUser(Long.parseLong(ID), token);
		if(user == null){
			
			DefualtPrintOut.printError(2, response);
			
			return;
			
		}
		
		if(user.getToken().equals(token)){
			
			JSONObject result = new JSONObject();
			result.put("code",1);
			result.put("result","");
			
			result.put("user", user);
			
			DefualtPrintOut.defaultPrint(result.toString(), response);
			
		}else{
			
			DefualtPrintOut.printError(3, response);
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
