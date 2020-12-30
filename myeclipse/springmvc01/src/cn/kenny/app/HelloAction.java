package cn.kenny.app;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView.addObject("message", "This is my first spring Mvc app");
		 modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}

}
