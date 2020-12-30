package com.atguigu.maven;

import com.atguigu.maven.Hello;

public class HelloFriend{
	public String sayHelloToFriend(String name){
		Hello hello=new Hello();
		String str= hello.sayHello(name)+ " i am " +this.getName();
		System.out.println(str);
		return str;
	}
	public  String getName(){
		return "John";
	}
}