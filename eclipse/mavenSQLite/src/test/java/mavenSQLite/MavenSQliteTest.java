package mavenSQLite;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

 

public class MavenSQliteTest {
  
	@Test
	public void testFindAllData() throws Exception {
		MavenSQliteDemo msd=new MavenSQliteDemo();
		msd.findAllData();
	}
	
	@Test
	public void testFindDatas() throws Exception {
		
		MavenSQliteDemo msd=new MavenSQliteDemo();
		String sql="Select * from emp where deptno=20";
		ResultSet rs=msd.findDatas(sql);
		 while(rs.next()) {
		  	   System.out.println("Number::"+"\t"+rs.getInt(1) + ":\t"+"name: "+rs.getString(2));
		     }
		
		
	}
	
	@Test
	public void testUpdateData() throws Exception{
		MavenSQliteDemo msd=new MavenSQliteDemo();
		String sql="update emp set ename='TAUNER'  where empno=7844";
		msd.updateData(sql);
	}
	
	@Test
	public void testDeleteData() throws Exception {
		MavenSQliteDemo msd=new MavenSQliteDemo();
		String sql="delete from emp  where ename='pussy'";
		msd.deleteData(sql);
	}
	
	@Test
	public void testAddData() throws Exception {
		
		MavenSQliteDemo msd=new MavenSQliteDemo();
		 String sql="insert into emp values(4000,'pussy','whore',7788,'1984-4-4',1700,100,40)";
		msd.insertNew(sql);
	}
}
