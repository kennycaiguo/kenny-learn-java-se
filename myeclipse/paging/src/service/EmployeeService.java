package service;

import dao.EmployeeDao;
import dao.IEmployeeDao;
import entity.Employee;
import utils.PageBean;

public class EmployeeService implements IEmployeeService {

	private IEmployeeDao empdao=new EmployeeDao();
	
	public void getAll(PageBean<Employee> pb) {
		 
		 empdao.getAll(pb);
	}

	 
}
