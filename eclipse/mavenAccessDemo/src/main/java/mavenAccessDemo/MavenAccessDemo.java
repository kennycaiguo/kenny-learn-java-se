package mavenAccessDemo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenAccessDemo {
	
    public static Connection getConnection() throws Exception {
    	Connection conn=DriverManager.getConnection(
    	        "jdbc:ucanaccess://src/company.mdb");
    	 
    	return conn;
    }
    
    public ResultSet ShowAllData() throws Exception {
    	Connection con=getConnection();
    	
    	Statement s = con.createStatement();
    	ResultSet rs = s.executeQuery("SELECT * FROM [emp]");
    	
    	return rs;
    }
    
    public ResultSet findById(int num) throws Exception {
    	
         Connection con=getConnection();
    	
    	Statement s = con.createStatement();  
    	ResultSet rs = s.executeQuery("SELECT * FROM [emp] where empno=7499 ");
    	
    	return rs;
    }
    
    public static void updateData(String sql) throws Exception, SQLException {
       	Connection con=getConnection();
       	Statement s =con.createStatement();
       	s.execute(sql);
       	s.close();
     }
       
       public static void insertNew(String sql) throws Exception {
       	 
    		Connection con=getConnection();
    		Statement s =con.createStatement();
    		s.execute(sql);
            s.close();
       }
       
       public static void deleteData(String sql) throws Exception {
  		 Connection con = getConnection();
  	        Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
  	       s.execute(sql);
  	       System.out.println("删除了一条记录");
  	       s.close();
  	}
}
