package org.kenny.app2_01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//����������
@Controller //ע�ⷽʽ�൱�ڼ̳л�ʵ�ֽӿ�
public class HelloAction {
	
  public HelloAction() {
	  System.out.println("HelloAction::HelloAction()"+this.hashCode());
	}

	//ҵ�񷽷�
	//��struts���ƣ�ֻ����������Դ�������Ҳ���Բ�����struts�ǲ��ܴ�������
	@RequestMapping(value={"/hello.action","/h.action","/he.action","/hel.action"}) //����ӳ�䣬���������/hello.action,��ƥ��ɹ�������д���
	public String hello(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","Hello,SpringMvc!!!ע��汾");
		return "success";//��������ʵ���Ʋ�Ҫ������ͼ������
		
	}
	@RequestMapping(value="/bye.action") //����ӳ�䣬���������/hello.action,��ƥ��ɹ�
	public String bye(Model model) throws Exception{
		System.out.println("HelloAction::bye()");
		model.addAttribute("message","Bye,SpringMvc!!!ע��汾");
		return "success";//����ʹ���߼���ͼ���ƣ���Ҫ������ͼ������
		
	}
}
