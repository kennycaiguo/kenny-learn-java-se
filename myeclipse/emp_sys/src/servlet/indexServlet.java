package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.Employee;
import serviceimpl.EmployeeService;
 
import services.IEmployeeService;

public class indexServlet extends HttpServlet {

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
		IEmployeeService empservice=new EmployeeService();
		List<Employee>list=empservice.getAll();
		 
			if(list!=null) {
				request.setAttribute("list", list);
			} 
			
		 request.getRequestDispatcher("/list.jsp").forward(request, response);
	}

	 
		 
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		this.doGet(request, response);
	}

}
