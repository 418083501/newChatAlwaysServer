package lulu.lulu;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class DefualtPrintOut {
/**1,参数错误 
 * @throws IOException */
	public static void printError(int type,HttpServletResponse response) throws IOException{
		
		if(type == 1){
//			response.getWriter().print("{code:\"0\",result:\"参数错误\"}");
			defaultPrint("{code:\"0\",result:\"参数错误\"}",response);
		}
	}
	
	public static void defaultPrint(String string,HttpServletResponse response) throws IOException{
		response.getWriter().print(string);
	}
	
}
