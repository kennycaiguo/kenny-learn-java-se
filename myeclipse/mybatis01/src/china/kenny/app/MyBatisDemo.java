package china.kenny.app;

import java.sql.Connection;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import china.kenny.util.MyBatisUtil;

public class MyBatisDemo {
	 @Test
	  public void test1(){
		 Connection connection = MyBatisUtil.getSqlSession().getConnection();
		  System.out.println(connection);
	  }
}
