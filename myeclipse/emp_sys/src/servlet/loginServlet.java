package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entity.Admin;
import serviceimpl.AdminService;
import services.IAdminService;

public class loginServlet extends HttpServlet {

	private String uri;
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
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		String userName=request.getParameter("userName"); 
		String pwd=request.getParameter("pwd"); 
		
		Admin ad=new Admin();
		ad.setUserName(userName);
		ad.setPwd(pwd);
		IAdminService service=new AdminService();
		Admin loginInfo=service.findByNameAndPdw(ad);	
		HttpSession session=request.getSession(false);
		if(loginInfo!=null) {
			session.setAttribute("loginInfo", loginInfo);
			uri="/index";
		}else {
			uri="/error/error.jsp";
		}
		request.getRequestDispatcher(uri).forward(request, response);	 
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		this.doGet(request, response);
	}

}
