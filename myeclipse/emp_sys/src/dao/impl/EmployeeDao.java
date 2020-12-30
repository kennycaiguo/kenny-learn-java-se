package dao.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import dao.IEmployeeDao;
import entity.Employee;
import utils.jdbcTool;

public class EmployeeDao implements IEmployeeDao {
     private QueryRunner qr;
     
	public List<Employee> getAll() {
		 qr=jdbcTool.getQueryRunner();
		 String sql="select * from employee";
		// Employee emp=new Employee();
		 
		try {
			  return qr.query(sql, new BeanListHandler<Employee>(Employee.class));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

	 

}
