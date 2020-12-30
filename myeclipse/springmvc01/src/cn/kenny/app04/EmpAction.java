package cn.kenny.app04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmpAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//设置浏览器字符编码
		  request.setCharacterEncoding("UTF-8");
		  ModelAndView modelAndView = new ModelAndView();
		  //获取表单传递的员工姓名
		  String username = request.getParameter("username");
		  System.out.println("员工姓名"+username);
		  //将员工姓名封装到modelandView中
		  modelAndView.addObject("message", username);
		  //将视图的真实路径设置到modelandView对象中
		  modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}

}
