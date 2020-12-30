package mysqltest;
import java.io.File;  
import java.io.IOException;  
import java.sql.SQLException;  
 
import java.util.Collections; 
import java.io.UnsupportedEncodingException;
import java.sql.*;
import com.*;
 
/*
 * 
 * 该实例使用的是D:\Program Files\Java\mysql-8.0.17-winx64\bin项目的mysql，是独立的mysql
 */
 

public class MySqlDemo {
    public static void main(String[] args) throws Exception {
    	  String url = "jdbc:mysql://localhost:3306/regusers?serverTimezone=UTC  "; //数据库连接
    	  String name = "com.mysql.cj.jdbc.Driver";   //程序驱动
    	  String user = "root";  //用户名
    	  String password = ""; //密码
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
  			 
  				System.out.println("姓名："+rs.getString(1));
  				System.out.println("密码："+rs.getString(2));
  				System.out.println("性别："+rs.getString(3));
  				//System.out.println("年龄："+rs.getString(4));
  				
  				System.out.println("邮箱："+rs.getString(4));
  				System.out.println("城市："+rs.getString(5));
  				System.out.println("爱好："+rs.getString(6));
  				System.out.println("介绍："+rs.getString(7));
  				
  			}
  			rs.close();
  			String sql2=null;
  			//修改
//  		 sql2="UPDATE users set name='mary' ,gender='female'  WHERE id='001'";
//  			pst = conn.prepareStatement(sql2);// 准备执行语句
//  			 pst.executeUpdate();
            //新增
  			 sql2="INSERT INTO users VALUES('lili','123456','female','tracy@pussy.net','newyork','222333','love girls')";
  			pst = conn.prepareStatement(sql2);
  			pst.executeUpdate();
  			//删除
//  			sql2="DELETE FROM users WHERE id='003'";
//  			pst = conn.prepareStatement(sql2);
//  			pst.executeUpdate();
  			 conn.close();
  		} catch (Exception e)
  		{
  			e.printStackTrace();
  			
  		}
    }
}
