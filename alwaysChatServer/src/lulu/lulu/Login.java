package lulu.lulu;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
		
		String username = (String)request.getParameter("username");
		String vcode = (String)request.getParameter("vcode");
		
//		DefualtPrintOut.defaultPrint(username + "," + vcode, response);
		
		if(username == null || vcode == null)
		{
			DefualtPrintOut.printError(1, response);
		}else{
			LoginUser user = new LoginUser();
			
			JSONObject result = new JSONObject();
			
//			JSONObject userJson = new JSONObject();
			
			result.put("code",1);
			result.put("result","");
			result.put("user", user);
			
//			userJson.put("ID",user.getID());
			
			DefualtPrintOut.defaultPrint(result.toString(), response);
			
		}
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
	}

}
