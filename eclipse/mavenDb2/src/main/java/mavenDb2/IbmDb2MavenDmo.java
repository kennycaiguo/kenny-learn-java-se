package mavenDb2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class IbmDb2MavenDmo {
	
	public static void deleteData(String sql) throws Exception {
		 Connection con = getConnection();
	        Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	       s.execute(sql);
	       System.out.println("删除了一条记录");
	       s.close();
	}
	 public static void findAllData() throws Exception {
	    	
   	 Connection con = getConnection();
       Statement s =con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
      
      ResultSet rs=s.executeQuery("select * from Administrator.EMP");
      while(rs.next()) {
   	   System.out.println("Number"+rs.getInt(1) + ":"+"name: "+rs.getString(2));
      }
      rs.close();
      s.close();
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
   	s.close();
 }
   
   public static void insertNew(String sql) throws Exception {
   	 
		Connection con=getConnection();
		Statement s =con.createStatement();
		s.execute(sql);
        s.close();
   }
}
