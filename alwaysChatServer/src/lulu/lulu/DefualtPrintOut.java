package lulu.lulu;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class DefualtPrintOut {
/**1,参数错误 
 * @throws IOException */
	public static void printError(int type,HttpServletResponse response) throws IOException{
		
		if(type == 1){
//			response.getWriter().print("{code:\"0\",result:\"参数错误\"}");
			defaultPrint("{\"code\":\"0\",\"result\":\"参数错误\"}",response);
		}else if(type == 2){
			defaultPrint("{\"code\":\"0\",\"result\":\"为查找到用户\"}",response);
			
		}else if(type == 3){
			defaultPrint("{\"code\":\"0\",\"result\":\"token failure\"}",response);
			
		}
	}
	
	public static void defaultPrint(String string,HttpServletResponse response) throws IOException{
		
		response.setContentType("text/json");
		
		response.getWriter().print(string);
		
	}
	
}
