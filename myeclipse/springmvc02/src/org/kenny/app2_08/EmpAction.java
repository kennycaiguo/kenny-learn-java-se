package org.kenny.app2_08;

import java.util.Date;
import java.util.List; 

import oracle.net.aso.b;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
 

@Controller
@RequestMapping(value="/emp")
public class EmpAction{
	
	  public EmpAction(){}
	  @RequestMapping(value="/addAll",method=RequestMethod.POST)
	  public String addAll(Model model,Bean bean) throws Exception{
		   List<Emp> emps=bean.getEmpList();
		  for (Emp emp : emps) {
			System.out.println(emp);
		}
		  model.addAttribute("message", "批量增加员工成功");
		  model.addAttribute("emps", emps);
		return "/jsp/addsuccess.jsp";
		
	}
      
  }
    

