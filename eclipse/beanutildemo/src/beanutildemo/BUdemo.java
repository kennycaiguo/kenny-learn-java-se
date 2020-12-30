package beanutildemo;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConversionException;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;
import org.junit.Test;

public class BUdemo {

	 String name="Mary";
	 String age="20";
     String birth="1999-05-20";
     String pwd=null;
     
     @Test //用BeanUtils进行日期转换
     public void testStrDate() throws  Exception {
    	 
         //ConvertUtils.register(new DateLocaleConverter(), java.util.Date.class);
    	// ConvertUtils.register(new DateConverter(), java.util.Date.class);不行
    	   //StringToDateConverter是自定义的日期转换器类
         ConvertUtils.register(new StringToDateConverter(), java.util.Date.class);
         
    	 Admin a =new Admin();
    	 BeanUtils.copyProperty(a, "name", name);
    	 BeanUtils.copyProperty(a, "age", age);
    	 BeanUtils.copyProperty(a, "birth", birth);
    	 
    	 System.out.println(a);
     }
     
}