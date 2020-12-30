package cn.kenny.app02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("message", "This is my second spring Mvc app");
		 //封装视图的真实路径
		 //modelAndView.setViewName("/jsp/success.jsp");
		 
		 ////封装视图的逻辑名称
		 modelAndView.setViewName("success");
		return modelAndView;
	}

}
