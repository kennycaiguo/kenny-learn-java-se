package kenny.action;

import kenny.app.Emp;
import kenny.service.EmpService;

import com.opensymphony.xwork2.ActionSupport;

public class EmpAction extends ActionSupport {
	
	private EmpService empService;
	
    public void setEmpService(EmpService empService) {
		this.empService = empService;
	}

	private Emp emp;

	public Emp getEmp() {
		return emp;
	}
	
	public void setEmp(Emp emp) {
		this.emp = emp;
	}
	
   public String registerMethod() throws Exception{
	   empService.addEmp(emp);
	   return SUCCESS;
   }
}
