package cn.itcast.test.service.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.itcast.test.dao.TestDao;
import cn.itcast.test.entity.Person;

@Service("testService")
public class TestServiceImpl implements cn.itcast.test.service.TestService {
	@Resource
	TestDao testDao;
	public void say() {
		System.out.println("say hi");
	}

	@Override
	public void save(Person  person) {
		testDao.save(person);	
	}

	@Override
	public Person findPerson(Serializable id) {
		// TODO Auto-generated method stub
		//testDao.save(new Person("test"));
		return testDao.findPerson(id);
	}

}
