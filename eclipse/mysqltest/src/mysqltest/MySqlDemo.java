package mysqltest;
import java.io.File;  
import java.io.IOException;  
import java.sql.SQLException;  
 
import java.util.Collections; 
import java.io.UnsupportedEncodingException;
import java.sql.*;
import com.*;
 
public class MySqlDemo {
    public static void main(String[] args) throws Exception {
    	  String url = "jdbc:mysql://localhost:3306/regusers?serverTimezone=UTC  "; //数据库连接
    	  String name = "com.mysql.cj.jdbc.Driver";   //程序驱动
    	  String user = "root";  //用户名
    	  String password = "root"; //密码
          String sql="select * from users";//查询语句
    	  
    	  Connection conn = null;
    	  PreparedStatement pst = null;
    	  try
  		{
  			Class.forName(name);// 指定连接类型
  			conn = DriverManager.getConnection(url, user, password);// 获取连接
  			pst = conn.prepareStatement(sql);// 准备执行语句
  			 //Statement statement = conn.createStatement();
  			ResultSet rs = pst.executeQuery();
  			while(rs.next()) {//读取数据
  				System.out.println("编号："+rs.getString(1));
  				System.out.println("姓名："+rs.getString(2));
  				System.out.println("性别："+rs.getString(3));
  				System.out.println("生日："+rs.getString(4));
  				System.out.println("手机："+rs.getString(5));
  				System.out.println("邮箱："+rs.getString(6));
  				System.out.println("QQ："+rs.getString(7));
  				
  			}
  			rs.close();
  			//修改
  			String sql2="UPDATE users set name='LILI' ,gender='female'  WHERE name='MARY'";
  			pst = conn.prepareStatement(sql2);// 准备执行语句
  			 pst.executeUpdate();
            //新增
//  			 sql2="INSERT INTO users VALUES('003','Tom','male','25','13532619000','tracy@pussy.net','222333')";
//  			pst = conn.prepareStatement(sql2);
//  			pst.executeUpdate();
  			//删除
//  			sql2="DELETE FROM users WHERE name='kk'";
//  			pst = conn.prepareStatement(sql2);
//  			pst.executeUpdate();
  			 conn.close();
  		} catch (Exception e)
  		{
  			e.printStackTrace();
  			
  		}
    }
}
