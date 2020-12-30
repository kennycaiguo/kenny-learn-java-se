package cn.kenny.app03;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class UserAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		System.out.println("inside UserAction hahaha。。。");
		 ModelAndView modelAndView=new ModelAndView();
		 modelAndView .addObject("message","操作用户成功");
		 modelAndView.setViewName("success");
		 
		return modelAndView;
	}

}
