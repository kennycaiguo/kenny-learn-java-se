package SQLServer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLServerDemo {
	
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
  	    s.close();
  }
    
    public static void insertNew(String sql,ArrayList datas) throws Exception {
    	//String sql="insert into EMP values(?,?,?,?,?,?,?,?)";
		Connection con=getConnection();
		PreparedStatement ps =con.prepareStatement(sql);
//		ps.setInt(1, 555);
//		ps.setString(2, "PHILLIP2");
//		ps.setString(3, "CLERK");
//		ps.setInt(4, 7902);
//		ps.setString(5, "1980-01-01");
//		ps.setInt(6, 780);
//		ps.setInt(7, 120);
//		ps.setInt(8, 20);
//		ps.execute();
		ps.setInt(1, (int)datas.get(0));
		ps.setString(2, (String)datas.get(1));
		ps.setString(3, (String)datas.get(2));
		ps.setInt(4, (int)datas.get(3));
		ps.setString(5, (String)datas.get(4));
		ps.setInt(6, (int)datas.get(5));
		ps.setInt(7, (int)datas.get(6));
		ps.setInt(8, (int)datas.get(7));
		ps.execute();
		ps.close();
    }
    
    public static void deleteData(String sql) throws Exception{
    	Connection con=getConnection();
    	Statement s=con.createStatement();
    	s.execute(sql);
    	System.out.println("删除了一条记录");
    	s.close();
    }
}
