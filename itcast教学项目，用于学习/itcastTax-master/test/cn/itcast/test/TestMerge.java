package cn.itcast.test;

import static org.junit.Assert.*;

import javax.persistence.Transient;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.config.TxNamespaceHandler;

import cn.itcast.test.entity.Person;
import cn.itcast.test.service.TestService;
import cn.itcast.test.service.impl.TestServiceImpl;

public class TestMerge {
	ClassPathXmlApplicationContext ctx;

	@Before
	public void loadCtx()  {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
	}

	@Test
	public void testSpring() {
		TestService testService=(TestService) ctx.getBean("testService");
		testService.say();
	}
	@Test
	public void testHibernate(){
		SessionFactory sessionFactory=(SessionFactory) ctx.getBean("sessionFactory");
		Session session=sessionFactory.openSession();
		Transaction transaction=session.beginTransaction();
		
		session.save(new Person("人员1"));
		transaction.commit();
		session.close();
	}
	@Test
	public void testServiceAndDao(){
		TestService ts=(TestService) ctx.getBean("testService");
		//ts.save(new Person("人员2"));
		System.out.println(ts.findPerson("40282f815557f903015557f90a740001").getName());
	}
	@Test
	public void testTrans(){
		TestService ts=(TestService) ctx.getBean("testService");
		//ts.save(new Person("人员2"));
		//测试
		System.out.println(ts.findPerson("40282f815557f903015557f90a740001").getName());
	}

}
