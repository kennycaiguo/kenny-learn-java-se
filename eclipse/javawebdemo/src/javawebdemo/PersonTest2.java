package javawebdemo;
//这个例子演示了BeforeClass方法和AfterClass方法的使用
 //这个不常用
import org.junit.AfterClass;
 
import org.junit.BeforeClass;
import org.junit.Test;
 

public class PersonTest2 {
	@BeforeClass
	 public static void beforeClass() {
		 System.out.println("Before Class.....");
	 }
	
    @Test
	public void testRun() {
    	                                   Person p =new Person();
    	                          p.run();
    	}
    @Test
   	public void testEat() {
    	  Person p =new Person();
       	                          p.eat();
       	}
     @AfterClass
    public static void afterClass() {
		 System.out.println("After Class.....");
	 }
}
