package oracleTesrt;
 
import java.sql.*;

public class OrcleDataTest {
	static String username="scott";
	static String password="tiger";
	static String url = "jdbc:oracle:thin:@localhost:1521:orcl"; // 路径
	 
	static Connection conn=null;
	
	public  OrcleDataTest() {
		
	}
 public static void main(String[] args) throws ClassNotFoundException, Exception {
	Class.forName("oracle.jdbc.driver.OracleDriver");
	conn=DriverManager.getConnection(url,username, password);
    Statement  st=conn.createStatement();
	String sql="select * from emp";
	ResultSet rs = st.executeQuery(sql);
	while(rs.next()) {
		System.out.println("姓名："+" " +rs.getString(2)+"===" +"工资：" +" "+rs.getInt(6));
	}
	System.out.println("Finish!!!");
	st.close();
	conn.close();
   }
}
