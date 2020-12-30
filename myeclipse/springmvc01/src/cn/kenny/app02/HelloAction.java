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
		 //��װ��ͼ����ʵ·��
		 //modelAndView.setViewName("/jsp/success.jsp");
		 
		 ////��װ��ͼ���߼�����
		 modelAndView.setViewName("success");
		return modelAndView;
	}

}
