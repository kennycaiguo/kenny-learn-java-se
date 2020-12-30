package JavaSQLserver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JavaSQLserver {
    public static ResultSet findAllData() throws Exception {
    	
    	 Connection con = getConnection();
        Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
       
       ResultSet rs=s.executeQuery("select * from EMP");
       return rs;
       
    }
    
    public static ResultSet findDatas(String sql) throws Exception {
    	
   	    Connection con = getConnection();
       Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      
      ResultSet rs=s.executeQuery(sql);
      return rs;
      
   }

	public static Connection getConnection()
			throws ClassNotFoundException, SQLException {
		String url="jdbc:sqlserver://127.0.0.1:1433 ;databaseName=company";
        String user="boss";
        String pass="kenny1975";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
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
		PreparedStatement ps =con.prepareStatement(sql);
		ps.setInt(1, 555);
		ps.setString(2, "PHILLIP2");
		ps.setString(3, "CLERK");
		ps.setInt(4, 7902);
		ps.setString(5, "1980-01-01");
		ps.setInt(6, 780);
		ps.setInt(7, 120);
		ps.setInt(8, 20);
		ps.execute();
    }
	public static void main(String[] args) throws ClassNotFoundException, Exception {
		// TODO Auto-generated method stub
         //String sql="select * from Emp";
		//int num=7521;
		//String sql="select * from Emp where EMPNO=" +num;
		//新增数据
//			String sql="insert into EMP values(?,?,?,?,?,?,?,?)";
//			insertNew(sql);
		
		//查找所有数据
         //ResultSet rs=findAllData();
		//按条件查找
//		int num=7521;
//		String sql="select * from EMP where EMPNO<"+num;
//		ResultSet rs=findDatas(sql);
//         while(rs.next()) {
//            	System.out.println(rs.getInt(1) + "===>" + rs.getString(2)+" $:==>" +rs.getInt(6));
//            }
		
	// 更新数据
//		String sql1="update EMP set ENAME='SMITHLEE' WHERE EMPNO=7369";
//		//String sql="update EMP set EMPNO=EMPNO-200 WHERE EMPNO>7500";
//		updateData(sql1);
		
		//删除数据
		String sql="delete from EMP WHERE EMPNO="+4444;
		deleteData(sql);
		
	}

	private static void deleteData(String sql) throws Exception, SQLException {
		// TODO Auto-generated method stub
		Connection c=getConnection();
	Statement s=c.createStatement();
	s.execute(sql);
		
	}

}
