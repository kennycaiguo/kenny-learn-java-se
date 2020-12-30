package javawebdemo;
//这个例子演示了BeforeClass方法和AfterClass方法的使用
//以下是一些快捷键
//ctrl+shift+o：导包
//ctrl+shift+向下：向下复杂
//alt+向上：选中代码上移
//alt+向下：选中代码下移
//ctrl+T：查看类的继承关系
 //这个不常用
import org.junit.AfterClass;
 
import org.junit.BeforeClass;
import org.junit.Test;

import junit.framework.Assert;
 

public class PersonTest3 {
 
	
    @Test
	public void testRun() {
    	                                   Person p =new Person();
    	                          p.run();
    	                          Assert.assertEquals("1", p.run());//如果期望值与结果不相符，测试不通过
    	}
    @Test
   	public void testEat() {
    	Person p =new Person();
    	 
       	                          p.eat();
       	}
    
}
