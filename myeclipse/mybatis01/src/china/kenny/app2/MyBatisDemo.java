package china.kenny.app2;

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
