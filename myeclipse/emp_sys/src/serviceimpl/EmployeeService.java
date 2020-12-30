package serviceimpl;

import java.util.List;

import dao.IEmployeeDao;
import dao.impl.EmployeeDao;
import entity.Employee;
import services.IEmployeeService;

public class EmployeeService implements IEmployeeService {

	public List<Employee> getAll() {
		 IEmployeeDao empDao=new EmployeeDao();
		return empDao.getAll();
	}

	 
	}


