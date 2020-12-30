package org.kenny.app2_05;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
 
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value="/user")
public class UserAction {
	
	//自定义类型转换器
	@InitBinder
	protected void initBinder(HttpServletRequest request, 
   		 ServletRequestDataBinder binder) throws Exception {
		  
		 binder.registerCustomEditor(Date.class, 
				 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
		 
	 }
	 
	@RequestMapping(value="/register",method=RequestMethod.POST)//设置方法只能接受post请求
    public String register(User user,Model model) throws Exception{//利用模型接受参数
		  System.out.println("用户注册"+user.toString());
		  //将user绑定到模型中
    	  model.addAttribute("user", user);
    	 return "/jsp/successu.jsp"; 
    }
 
}
