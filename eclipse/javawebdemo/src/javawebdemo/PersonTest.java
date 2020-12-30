package javawebdemo;
//这个例子演示了Before方法和After方法的使用

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
 

public class PersonTest {
	Person p ;
	@Before
	public void before() {
		
		//System.out.println("Before.....");
		 p =new Person();  
	}
	
    @Test
	public void testRun() {
    	                           
    	                          p.run();
    	}
    @Test
   	public void testEat() {
       	                         
       	                          p.eat();
       	}
    @After
    public void after() {
    	//System.out.println("After.....");
    	p=null;
    }
}
