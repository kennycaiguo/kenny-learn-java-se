package dao.impl;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import dao.IAdminDao;
import entity.Admin;
import utils.jdbcTool;

public class Admindao implements IAdminDao {
     
	private QueryRunner qr;
	
	public Admindao() {
		// TODO Auto-generated constructor stub
	}

	public Admin findByNameAndPwd(Admin admin){
	     qr=jdbcTool.getQueryRunner();
	     String sql="Select * from admin where userName=? and pwd=?";
	     
		try {
			return qr.query(sql, new BeanHandler<Admin>(Admin.class),admin.getUserName(),admin.getPwd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}

}
