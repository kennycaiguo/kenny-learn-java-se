package zmt.kenny.action;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zmt.kenny.entity.Emp;
import zmt.kenny.service.EmpService;
   
  
@Controller
@RequestMapping(value="/emp")
public class EmpAction {
	//IOC 容器注入
	  private EmpService empService;
	  @Resource(name="empService")
	  public void setEmpService(EmpService empService) {
		this.empService = empService;
	}
  //注册员工
	  @RequestMapping(value="/register")
	public String registerMethod(Emp emp) throws Exception{
		empService.register(emp);
		return "success";
		
	}
}
