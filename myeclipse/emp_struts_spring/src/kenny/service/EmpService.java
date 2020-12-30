package kenny.service;

import java.util.Set;

import javax.management.RuntimeErrorException;

import kenny.app.Emp;
import kenny.dao.EmpDao;

public class EmpService {
	private EmpDao empDao;
	
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
	
public void addEmp(Emp  emp) throws Exception{
	    if(emp==null){
	    	throw new RuntimeException("EmpService参数不能为空");
	    }
	    empDao.add(emp);
	   
   }
}
