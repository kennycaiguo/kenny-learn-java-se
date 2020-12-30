package org.kenny.app2_03;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//Ա��ע�ᣬ�����������ֻ�ܽ���post���� //ok
	@RequestMapping(value="/register",method=RequestMethod.POST)//����������ͨ�����ռ��������׶ˣ���������ܶ࣬����ͦ�鷳��
    public String register(Model model,String username,double salary) throws Exception{
		System.out.println("register ->user: "+username+"\t"+"salary: " +salary);
    	model.addAttribute("message", "Ա��ע��ɹ�������");
    	return "success";
    }
	
	//Ա����½��������������ܽ���post��get���� //ok,����Ĭ�ϵ�
	@RequestMapping(value="/login",method={RequestMethod.POST,RequestMethod.GET})
	public String login(Model model,String username) throws Exception{
		System.out.println("login ->user: "+username);
		model.addAttribute("message", "��½�ɹ�������");
		return "success";
	}
}
