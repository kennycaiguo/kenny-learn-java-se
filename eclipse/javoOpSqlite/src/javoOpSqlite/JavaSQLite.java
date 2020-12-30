package javoOpSqlite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaSQLite {
	
	public static void deleteData(String sql) throws Exception {
		 Connection con = getConnection();
	        Statement s =con.createStatement();
	       s.execute(sql);
	}
	 public static void findAllData() throws Exception {
	    	
   	 Connection con = getConnection();
       Statement s =con.createStatement();
      
      ResultSet rs=s.executeQuery("select * from EMP");
      while(rs.next()) {
   	   System.out.println("Number::"+"\t"+rs.getInt(1) + ":\t"+"name: "+rs.getString(2));
      }
      
   }
   
   public static ResultSet findDatas(String sql) throws Exception {
   	
  	    Connection con = getConnection();
      Statement s =con.createStatement();
     
     ResultSet rs=s.executeQuery(sql);
     return rs;
     
  }

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		String url="jdbc:sqlite:src/company.sqlite";
       
       Class.forName("org.sqlite.JDBC");
       Connection con=DriverManager.getConnection(url);
		return con;
	}
	
   public static void updateData(String sql) throws Exception, SQLException {
   	Connection con=getConnection();
   	Statement s =con.createStatement();
   	s.execute(sql);
 	
 }
   
   public static void insertNew(String sql) throws Exception {
   	//String sql="insert into EMP values(?,?,?,?,?,?,?,?)";
		Connection con=getConnection();
		Statement s =con.createStatement();
		s.execute(sql);
//		PreparedStatement ps =con.prepareStatement(sql);
//		ps.setInt(1, 100);
//		ps.setString(2, "PHILLIP2");
//		ps.setString(3, "CLERK");
//		ps.setInt(4, 7902);
//		ps.setString(5, "1980-01-01");
//		ps.setInt(6, 780);
//		ps.setInt(7, 120);
//		ps.setInt(8, 20);
//		ps.execute();
   }
   
     public static void main(String[] args) throws Exception {
    	 //查询所有数据
		findAllData();
    	 //============条件查询===============
    	 //
//    	 String sql="Select * from emp where deptno=20";
//    	 ResultSet rs=findDatas(sql);
//    	 while(rs.next()) {
//    		 System.out.println("Number:\t"+rs.getInt(1) + ":\t"+"name:\t "+rs.getString(2)+"\t<Salary>::"+rs.getInt(6));
//    	 }
    	 //
    	 //**********************插入数据***************************
    	 //
//    	 String sql="insert into emp values(4000,'pussy','whore',7788,'1984-4-4',1700,100,40)";
//    	 insertNew(sql);
		//#############修改数据###################
		//
//		String sql="update emp set ename='vagina' where ename='pussy'";
//		updateData(sql);
    	 
    	 //+++++++++++++++++++删除数据+++++++++++++++++++++
//    	 String sql="delete from emp where ename='vagina'";
//    	 deleteData(sql);
	}
}
