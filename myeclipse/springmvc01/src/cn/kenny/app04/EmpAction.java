package cn.kenny.app04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class EmpAction implements Controller {

	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		//����������ַ�����
		  request.setCharacterEncoding("UTF-8");
		  ModelAndView modelAndView = new ModelAndView();
		  //��ȡ�����ݵ�Ա������
		  String username = request.getParameter("username");
		  System.out.println("Ա������"+username);
		  //��Ա��������װ��modelandView��
		  modelAndView.addObject("message", username);
		  //����ͼ����ʵ·�����õ�modelandView������
		  modelAndView.setViewName("/jsp/success.jsp");
		return modelAndView;
	}

}
