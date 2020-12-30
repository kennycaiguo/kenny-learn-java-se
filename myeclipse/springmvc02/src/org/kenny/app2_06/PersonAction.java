package org.kenny.app2_06;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value="/person")
public class PersonAction {
	
	//自定义类型转换器
		@InitBinder
		public void initBinder(HttpServletRequest request, 
	   		 ServletRequestDataBinder binder) throws Exception {
			  
			 binder.registerCustomEditor(Date.class, 
					 new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
			 
		 }
		@RequestMapping(value="/register")	
    public String registerMethod(Bean bean,Model model) throws Exception{
    	System.out.println("用户：" +bean.getUser());
    	System.out.println("管理员：" +bean.getAdmin());
    	model.addAttribute("user", bean.getUser());
    	model.addAttribute("admin", bean.getAdmin());
    	
		return "/addperson.jsp";
    	
    }
}
