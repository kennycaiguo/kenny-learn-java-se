package mavenAccessDemo;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Test;

public class MavenAccessTest {
  @Test
  public void testShowAll() throws Exception {
	  MavenAccessDemo mad=new MavenAccessDemo();
	  ResultSet rs=mad.ShowAllData();
	  while (rs.next()) {
  	    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(6)+"\t"+rs.getInt(8)+"\t");
  	}
	  rs.close();
  }
	
  @Test
  public void testFindById() throws Exception {
	  MavenAccessDemo mad=new MavenAccessDemo();
	  int num=7499;
	  ResultSet rs=mad.findById(num);
	  while (rs.next()) {
	  	    System.out.println(rs.getInt(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getInt(6)+"\t"+rs.getInt(8)+"\t");
	  	}
	  rs.close();
  }
  
  @Test
  public void testAdd() throws Exception {
	  MavenAccessDemo mad=new MavenAccessDemo();
	  
		  String sql="insert into EMP(EMPNO,ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values(6667,'JANE','clerk',7566,'1980/01/01',800,100,20)";
		  mad.insertNew(sql);
	   
  }
  
  @Test
  public void testUpdateData() throws Exception{
	  MavenAccessDemo mad=new MavenAccessDemo();
	  String sql="update EMP set ename='kelly clerkson' where empno=8000";
	  mad.updateData(sql);
  }
  
  @Test
  public void testDelete() throws Exception {
	  MavenAccessDemo mad=new MavenAccessDemo();
	  String sql="delete from emp where ename='JANE'";
	  mad.deleteData(sql);
  }
}
