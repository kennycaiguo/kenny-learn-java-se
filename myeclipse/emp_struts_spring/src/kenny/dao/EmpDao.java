package kenny.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import kenny.app.Emp;
import kenny.util.JdbcUtils;

public class EmpDao {
	
   public void add(Emp emp) throws Exception{
	   QueryRunner qRunner=JdbcUtils.getQueryRunner();
	   String sql="insert into emps(id,username,salary) values(?,?,?)";
	   Object[] params={emp.getId(),emp.getUsername(),emp.getSalary()};
	   qRunner.update(sql, params);
   }
   
   @Test
   public void testAdd() throws Exception {
	// TODO Auto-generated method stub
      EmpDao dao=new EmpDao();
      
      dao.add(new Emp("pussy",3000.00));
  }
}
