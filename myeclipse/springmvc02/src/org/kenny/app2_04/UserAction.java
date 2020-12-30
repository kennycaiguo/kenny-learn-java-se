package org.kenny.app2_04;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//Ա��ע�ᣬ�����������ֻ�ܽ���post���� //ok
	@RequestMapping(value="/register",method=RequestMethod.POST)//��������request��response�����ռ�����
    public String register(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 //��ȡ�û�����нˮ
    	 String username=request.getParameter("username");
    	 String salary=request.getParameter("salary");
    	 System.out.println("register ->user: "+username+"\t"+"salary: " +salary);
    	 //�󶨵�session�������
    	 
    	 request.getSession().setAttribute("username", username);
    	 request.getSession().setAttribute("salary", salary);
    	 
    	 //�ض���/jsp/success.jsp��
    	// response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
    	 return "/jsp/success.jsp"; //�ᳫ
    }
	
//	//Ա����½��������������ܽ���post��get���� //ok,����Ĭ�ϵ�
//	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
//	public String login(Model model,String username) throws Exception{
//		System.out.println("login ->user: "+username);
//		model.addAttribute("message", "��½�ɹ�������");
//		return "success";
//	}
}
