package soy.kenny.dao.impl;

import java.math.BigDecimal;
import java.util.List;

import javax.management.Query;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.sun.org.apache.bcel.internal.generic.NEW;

import soy.kenny.dao.inter.IEmpDao;
import soy.kenny.entity.Emp;
import soy.kenny.util.JdbcUtils;

public class EmpDao implements IEmpDao {

	public Integer getAllRecord() throws Exception {
		QueryRunner qr=JdbcUtils.getQueryRunner();
		String sql="select count(empno) from emp ";
		 BigDecimal bigDecimal=qr.query(sql, new ScalarHandler());
		return  bigDecimal.intValue();
	}
	 

	public List<Emp> findAllRecord(int start, int end) throws Exception {
		QueryRunner qr=JdbcUtils.getQueryRunner();
		String sql = " SELECT XX.EMPNO,XX.ENAME,XX.JOB,XX.MGR,XX.HIREDATE,XX.SAL,XX.COMM,XX.DEPTNO" +
                " FROM (SELECT ROWNUM ID,EMP.* FROM EMP WHERE ROWNUM<?) XX" +
                " WHERE ID>?";
		//Object[] params = {end,start};
		//return qr.query(sql, new BeanListHandler<Emp>(Emp.class),params);
		return qr.query(sql, new BeanListHandler<Emp>(Emp.class),end,start);
	}
	public static void main(String[] args) throws Exception {
		System.out.println(new EmpDao().findAllRecord(0, 4));
	}
}
