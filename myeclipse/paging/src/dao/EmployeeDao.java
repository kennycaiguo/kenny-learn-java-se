package dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import entity.Employee;
import utils.PageBean;
import utils.jdbcTool;

public class EmployeeDao implements IEmployeeDao {

	public void getAll(PageBean pb) {
		 
        int totalCount=this.getTotalCount();
        pb.setTotalCount(totalCount);
        
        //�����ﴦ��ҳ���������⣬���Ѿ�����ҳ�ˣ��ٵ������һҳ�� �����Ѿ������һҳ���ٵ������һҳ������������
        if(pb.getCurrentPage()<=0)
        {
        	pb.setCurrentPage(1);
        }else if(pb.getCurrentPage()>pb.getTotalPage()) {
        	pb.setCurrentPage(pb.getTotalPage());
        }
        
        int currentPage=pb.getCurrentPage();
        int index=(currentPage-1)*pb.getPageCount();
        int count=pb.getPageCount();
        
       
        
        String sql="select * from employee limit ?,?";
        try {
        	QueryRunner qr=jdbcTool.getQueryRunner();
        	List<Employee> pageData=qr.query(sql, new BeanListHandler<Employee>(Employee.class),index,count);
            pb.setPageData(pageData);
        }catch(Exception e) {
        	throw new RuntimeException(e);
        }
	}

	public int getTotalCount() {
		
		String sql="Select count(*) from employee";
		Long count;
		try {
			QueryRunner qr=jdbcTool.getQueryRunner();
			 count= qr.query(sql, new ScalarHandler<Long>());
			 return count.intValue();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		 
	}

}
