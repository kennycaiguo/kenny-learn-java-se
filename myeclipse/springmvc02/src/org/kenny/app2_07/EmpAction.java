package org.kenny.app2_07;

import java.util.Date;
import java.text.SimpleDateFormat;
 

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindException;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

@Controller
@RequestMapping(value="/emp")
public class EmpAction{
	
	  public EmpAction(){}
	  @RequestMapping(value="/deleteAll",method=RequestMethod.POST)
	  public String deleteAll(Model model,int[] ids) throws Exception{
		  System.out.println("需要删除的员工编号如下：");
		  for (int i : ids) {
			System.out.println(i);
		}
		  model.addAttribute("message", "批量删除数据成功");
		  model.addAttribute("ids", ids);
		return "/jsp/delsuccess.jsp";
		
	}
      
  }
    

