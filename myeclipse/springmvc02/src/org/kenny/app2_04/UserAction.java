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
	
	//员工注册，设置这个方法只能接受post请求 //ok
	@RequestMapping(value="/register",method=RequestMethod.POST)//以下利用request和response变量收集参数
    public String register(HttpServletRequest request,HttpServletResponse response) throws Exception{
		 //获取用户名和薪水
    	 String username=request.getParameter("username");
    	 String salary=request.getParameter("salary");
    	 System.out.println("register ->user: "+username+"\t"+"salary: " +salary);
    	 //绑定到session域对象中
    	 
    	 request.getSession().setAttribute("username", username);
    	 request.getSession().setAttribute("salary", salary);
    	 
    	 //重定向到/jsp/success.jsp中
    	// response.sendRedirect(request.getContextPath()+"/jsp/success.jsp");
    	 return "/jsp/success.jsp"; //提倡
    }
	
//	//员工登陆，设置这个方法能接受post和get请求 //ok,这是默认的
//	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
//	public String login(Model model,String username) throws Exception{
//		System.out.println("login ->user: "+username);
//		model.addAttribute("message", "登陆成功！！！");
//		return "success";
//	}
}
