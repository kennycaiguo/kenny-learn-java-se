package cr.kenny.util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtil4 {
	
   private static ThreadLocal<SqlSession> threadLocal=new ThreadLocal<SqlSession>();
   private static SqlSessionFactory sqlSessionFactory;
   private MyBatisUtil4(){}  
   
   static{
	   try {
			Reader reader=Resources.getResourceAsReader("mybatis4.xml");
			sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		throw new RuntimeException(e);
	}
   }
   
   /*
    * 
    * */
   public static SqlSession getSqlSession(){
	    //从当前线程中获取SqlSession对象
	    SqlSession sqlSession=threadLocal.get();
	    if(sqlSession==null){
	    	 //如果为空，就利用sqlSessionFactory来创建
	    	sqlSession=sqlSessionFactory.openSession();
	    	 //将sqlSession绑定到当前线程
	    	threadLocal.set(sqlSession);
	    }
	  return sqlSession;
	   
   }
   
   /*
    *  
    * */
   public static void closeSqlSession(){
	   
	   SqlSession sqlSession=threadLocal.get();
	    if(sqlSession!=null){
	     
	    	sqlSession.close();
	     
	    	 threadLocal.remove();
	    }
	   
   }
}
