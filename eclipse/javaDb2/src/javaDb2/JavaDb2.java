package javaDb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaDb2 {
	public static void deleteData(String sql) throws Exception {
		 Connection con = getConnection();
	        Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	       s.execute(sql);
	}
	 public static void findAllData() throws Exception {
	    	
    	 Connection con = getConnection();
        Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       
       ResultSet rs=s.executeQuery("select * from Administrator.EMP");
       while(rs.next()) {
    	   System.out.println("Number"+rs.getInt(1) + ":"+"name: "+rs.getString(2));
       }
       
    }
    
    public static ResultSet findDatas(String sql) throws Exception {
    	
   	    Connection con = getConnection();
       Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      
      ResultSet rs=s.executeQuery(sql);
      return rs;
      
   }

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		String url="jdbc:db2://localhost:50000/test";
        String user="boss";
        String pass="kenny1975";
        //Class.forName("com.ibm.db2.jcc.DB2Driver");
        Class.forName("com.ibm.db2.jcc.DB2Driver");
        Connection con=DriverManager.getConnection(url,user,pass);
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
		// TODO Auto-generated method stub
		//新增数据,因为这里将empno设置为自动增长，所以不要插入
		 String sql="insert into Administrator.EMP(ENAME,JOB,MGR,HIREDATE,SAL,COMM,DEPTNO) values('martin','clerk',0,'1980-1-1',700,0,20)";
		//String sql="insert into Administrator.EMP values('jackline','clerk',0,'1980-1-1',700,0,20)";错误，db2 不支持这种写法
		
		insertNew(sql);
		System.out.println("新增了一条记录");
		//查找所有数据
		 //findAllData();
		//根据条件查找
//		int num=1;
//		String sql="select * from Administrator.EMP where EMPNO<"+num;
//		ResultSet rs=findDatas(sql);
//         while(rs.next()) {
//            	System.out.println(rs.getInt(1) + "===>" + rs.getString(2)+" $:==>" +rs.getInt(6));
//            }
		
		//修改数据
//		String sql="update Administrator.EMP set ename='kelly clerkson' where empno=4";
//		updateData(sql);
		//删除
//		int num=3;
//		String sql="delete from Administrator.EMP where EMPNO=" +num;
//		deleteData(sql);
//		System.out.println("删除了一条记录");
	}

}
