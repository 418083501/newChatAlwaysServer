package lulu.lulu;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class DefualtPrintOut {
/**1,�������� 
 * @throws IOException */
	public static void printError(int type,HttpServletResponse response) throws IOException{
		
		if(type == 1){
			response.getWriter().print("{code:\"0\",result:\"��������\"}");
			
		}
	}
	
}