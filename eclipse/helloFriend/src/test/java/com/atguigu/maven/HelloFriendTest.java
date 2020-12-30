package com.atguigu.maven;




import org.junit.Test;
import static junit.framework.Assert.*;
import com.atguigu.maven.Hello;

public class HelloFriendTest{
	@Test
	public void testHelloFriend(){
		HelloFriend hellofriend =new HelloFriend();
		String res=hellofriend.sayHelloToFriend("kenny");
		assertEquals("hello!!! kenny i am John",res);
	}
}