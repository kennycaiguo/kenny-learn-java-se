package cr.kenny.util;

import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;
 import java.sql.Connection;

public class JdbcUtils {

	 private static DataSource ds;
	 static {
		 ds=new ComboPooledDataSource();
	 }
	 
	 public static DataSource getDataSource(){
		 return  ds;
	 }
	 public static Connection getConnection() throws Exception{
		return ds.getConnection();
		 
	 }
     public static QueryRunner getQueryRunner() {
		return new QueryRunner(ds);
    	 
     }
}