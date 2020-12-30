package SQLServer;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.Test;

public class SQLServerDemoTest {
    @Test
	public void testFindAlldata() throws Exception {
		SQLServerDemo ssd=new SQLServerDemo();
		ResultSet rs=ssd.findAllData();
		while(rs.next()) {
			System.out.println(rs.getInt(1) + "===>" + rs.getString(2)+" $:==>" +rs.getInt(6));
		}
	}
    
    @Test
    public void testFindDatas() throws Exception {
    	SQLServerDemo ssd=new SQLServerDemo();
    	String sql="select * from emp where empno>7521";
    	ResultSet rs=ssd.findDatas(sql);
    	while(rs.next()) {
			System.out.println(rs.getInt(1) + "===>" + rs.getString(2)+" $:==>" +rs.getInt(6));
		}
    	rs.close();
    }
    
    @Test
    public void testUpdateDatas() throws Exception {
    	SQLServerDemo ssd=new SQLServerDemo();
    	String sql="update emp set ename='WARD' where empno=7521";
    	ssd.updateData(sql);
    	
    }
    
    @Test
    public void testInsertDatas() throws Exception {
    	SQLServerDemo ssd=new SQLServerDemo();
    	String sql="insert into EMP values(?,?,?,?,?,?,?,?)";
    	ArrayList datas=new ArrayList();
    	datas.add(5555);
    	datas.add("PILLIPH");
    	datas.add("CLERK");
    	datas.add(7902);
    	datas.add("1980-01-02");
    	datas.add(1000);
    	datas.add(120);
    	datas.add(20);
    	ssd.insertNew(sql,datas);
    }
    
    @Test
    public void testDeleteData() throws Exception{
    	SQLServerDemo ssd=new SQLServerDemo();
    	String sql="delete from emp where empno=5555";
    	ssd.deleteData(sql);
    }
}
