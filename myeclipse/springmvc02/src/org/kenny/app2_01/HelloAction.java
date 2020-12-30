package org.kenny.app2_01;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
//单例控制器
@Controller //注解方式相当于继承或实现接口
public class HelloAction {
	
  public HelloAction() {
	  System.out.println("HelloAction::HelloAction()"+this.hashCode());
	}

	//业务方法
	//跟struts类似，只不过这里可以带参数，也可以不带，struts是不能带参数的
	@RequestMapping(value={"/hello.action","/h.action","/he.action","/hel.action"}) //请求映射，如果请求是/hello.action,则匹配成功，可以写多个
	public String hello(Model model) throws Exception{
		System.out.println("HelloAction::hello()");
		model.addAttribute("message","Hello,SpringMvc!!!注解版本");
		return "success";//这里是真实名称不要配置视图解析器
		
	}
	@RequestMapping(value="/bye.action") //请求映射，如果请求是/hello.action,则匹配成功
	public String bye(Model model) throws Exception{
		System.out.println("HelloAction::bye()");
		model.addAttribute("message","Bye,SpringMvc!!!注解版本");
		return "success";//这里使用逻辑视图名称，需要配置视图解析器
		
	}
}
