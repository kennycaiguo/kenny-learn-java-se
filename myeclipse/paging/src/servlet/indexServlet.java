package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import service.EmployeeService;
import service.IEmployeeService;
import utils.PageBean;

public class indexServlet extends HttpServlet {

	 private IEmployeeService service=new EmployeeService();
	 private String uri;
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		try {
			String currPage=request.getParameter("currentPage");
			if(currPage==null ||"".equals(currPage.trim())) {
				currPage="1";
			}
			int currentPage=Integer.parseInt(currPage);
			
			PageBean<Employee> pageBean=new PageBean<Employee>();
			pageBean.setCurrentPage(currentPage);
			
			service.getAll(pageBean);
			
			request.setAttribute("pageBean", pageBean);
			uri="WEB-INF/list.jsp";
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			uri="error/error.jsp" ;
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
