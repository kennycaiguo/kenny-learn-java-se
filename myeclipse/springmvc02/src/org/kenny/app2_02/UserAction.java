package org.kenny.app2_02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//员工注册
	@RequestMapping(value="/register")
    public String register(Model model) throws Exception{
    	model.addAttribute("message", "员工注册成功！！！");
    	return "success";
    }
	
	//员工登陆
	@RequestMapping(value="/login")
	public String login(Model model) throws Exception{
		model.addAttribute("message", "登陆成功！！！");
		return "success";
	}
}
