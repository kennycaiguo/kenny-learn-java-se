package zmt.kenny.service;

import javax.annotation.Resource;

import zmt.kenny.dao.EmpDao;
import zmt.kenny.entity.Emp;

public class EmpService {
	//IOC容器注入
	private EmpDao empDao;
	@Resource(name="empDao")
	public void setEmpDao(EmpDao empDao) {
		this.empDao = empDao;
	}
   public void register(Emp emp) throws Exception{
	   empDao.add(emp);   
   }
}
