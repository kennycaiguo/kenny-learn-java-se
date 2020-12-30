package com.atguigu.maven;

import org.junit.Test;
import static junit.framework.Assert.*;
public class HelloTest{
	@Test
	public void testHello(){
		Hello hello =new Hello();
		String res=hello.sayHello("kenny");
		System.out.println(res);
		assertEquals("hello!!! kenny",res);
	}
}