package accessTest;

import java.sql.*;
import java.util.Properties;
/*
 * 
 * Connection conn=DriverManager.getConnection(
        "jdbc:ucanaccess://C:/__tmp/test/zzz.accdb");

 */
public class AccessDemo {
    public static void main(String[] args) throws Exception {
    	
    	Connection conn=DriverManager.getConnection(
    	        "jdbc:ucanaccess://src/student.mdb");
    	Statement s = conn.createStatement();
    	ResultSet rs = s.executeQuery("SELECT * FROM [student]");
    	//读取
    	while (rs.next()) {
    	    System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"\t"+rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t");
    	}
    	//新增
     	//Statement s1 = conn.createStatement();
     	//String sql="insert into student(stuname,gender,age,email,qq) values('ben','male','34','ben@gmail.com','223344')";
     	//String sql="insert into student values('alicia','female','34','alicia@gmail.com','223344')";
     	//s1.executeUpdate(sql);
     	//s1.close();
     	//修改
     	Statement s2 = conn.createStatement();
     	String sql="update student set stuname='alia' where age='23'";
     	s2.executeUpdate(sql);
     	conn.close();
    }

	}

