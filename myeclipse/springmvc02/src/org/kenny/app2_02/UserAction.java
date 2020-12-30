package org.kenny.app2_02;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//Ա��ע��
	@RequestMapping(value="/register")
    public String register(Model model) throws Exception{
    	model.addAttribute("message", "Ա��ע��ɹ�������");
    	return "success";
    }
	
	//Ա����½
	@RequestMapping(value="/login")
	public String login(Model model) throws Exception{
		model.addAttribute("message", "��½�ɹ�������");
		return "success";
	}
}
