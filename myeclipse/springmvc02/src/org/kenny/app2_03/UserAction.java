package org.kenny.app2_03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//员工注册，设置这个方法只能接受post请求 //ok
	@RequestMapping(value="/register",method=RequestMethod.POST)//以下利用普通变量收集参数，弊端，如果参数很多，操作挺麻烦的
    public String register(Model model,String username,double salary) throws Exception{
		System.out.println("register ->user: "+username+"\t"+"salary: " +salary);
    	model.addAttribute("message", "员工注册成功！！！");
    	return "success";
    }
	
	//员工登陆，设置这个方法能接受post和get请求 //ok,这是默认的
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(Model model,String username) throws Exception{
		System.out.println("login ->user: "+username);
		model.addAttribute("message", "登陆成功！！！");
		return "success";
	}
}
