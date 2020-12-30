package mavenSQLite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MavenSQliteDemo {
   
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

  }
  
}
