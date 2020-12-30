package soy.kenny.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import soy.kenny.entity.Page;
import soy.kenny.service.impl.EmpService;
import soy.kenny.service.inter.IEmpService;

public class EmpServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmpServlet() {
		 
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
    
 try{
	    //设置字符编码
	   request.setCharacterEncoding("UTF-8");
	  //获取客户端传入的参数
	   String strpage=request.getParameter("page");
	   //判断page是否为空，如果为空设置为“1”
	   if(strpage==null||strpage.trim().length()==0){
		   strpage="1";
	   }
	   //将字符串转换为整数
       Integer currPageNO=Integer.parseInt(strpage);
       //调用service方法
       IEmpService iEmpService=new EmpService();
      
		Page page=iEmpService.show(currPageNO);
		//创建map集合
		Map<String, Object> map=new LinkedHashMap<String, Object>();
		map.put("total", page.getAllRecordNO());
		map.put("rows",page.getEmpList());
		//使用第三方工具将map转换为Java格式的json
		JSONArray jsonArray=JSONArray.fromObject(map);
		System.out.println(jsonArray);
		String jsonJAVA=jsonArray.toString();
		//去掉两边的空格,
		jsonJAVA=jsonJAVA.substring(1,jsonJAVA.length()-1);
		//System.out.println(jsonJAVA);
		//以字符流 的方式将json字符流输出给客户端
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter pw = response.getWriter();
		pw.write(jsonJAVA);
		pw.flush();
		pw.close();
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
