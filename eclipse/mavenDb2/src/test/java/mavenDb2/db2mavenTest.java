package mavenDb2;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.jupiter.api.Test;

public class db2mavenTest {
    
	@Test
	public void testFindAllDatas() throws Exception {
		IbmDb2MavenDmo idmd=new IbmDb2MavenDmo();
		idmd.findAllData();
	}
	
	@Test
	public void testFindDatas() throws Exception {
		
		IbmDb2MavenDmo idmd=new IbmDb2MavenDmo();
		String sql="select * from Administrator.emp where empno<5";
		ResultSet rs=idmd.findDatas(sql);
		 
			while(rs.next()) {
			   	   System.out.println("Number"+rs.getInt(1) + ":"+"name: "+rs.getString(2));
			      }
			      rs.close();
		
	}
	 
	@Test
	public void testUpdateData() throws Exception {
		IbmDb2MavenDmo idmd=new IbmDb2MavenDmo();
		String sql="update Administrator.EMP set ename='Jelly fish' where empno=4";

		idmd.updateData(sql);
	}
	
	@Test
	public void testInsertNew() throws Exception {
		IbmDb2MavenDmo idmd=new IbmDb2MavenDmo();
		String sql="insert into Administrator.EMP(ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values('RICKY','clerk',0,'1980-10-1',700,0,20)";
		
		idmd.insertNew(sql);
	}
	
	@Test
	public void testDeleteData() throws Exception {
		IbmDb2MavenDmo idmd=new IbmDb2MavenDmo();
		String sql="delete from Administrator.EMP where ename='RICKY'";
		
		idmd.deleteData(sql);
	}
}
