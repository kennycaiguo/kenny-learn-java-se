package com.kenny.hello;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class SpringDemo {

	 @Test
	 public void userTest() {
		 //方式一
//		 Resource resource =new ClassPathResource("com/kenny/hello/applicationContext.xml");
//		 
//		 @SuppressWarnings("deprecation")
//		BeanFactory bf=new XmlBeanFactory(resource);
//		 User user=bf.getBean(User.class);
		 
		 //fs二
		 ApplicationContext ac=new ClassPathXmlApplicationContext("com/kenny/hello/applicationContext.xml");
		User user=ac.getBean(User.class);
		System.out.println(user.getId());
				
	 }

}
