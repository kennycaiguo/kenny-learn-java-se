package china.kenny.app3;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import china.kenny.util.MyBatisUtil;

public class StudentDao {
  
	public void Addstu(Student s) throws Exception{
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			 //调用映射文件里的sql语句进行插入操作，将Student对象s作为参数，默认是自动开启事务的
		   sqlSession.insert(Student.class.getName()+".addstu",s); 
			 //提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//有错误需要回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	public void update(Student s) throws Exception{
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			//调用映射文件里的sql语句进行插入操作，将Student对象s作为参数，默认是自动开启事务的
			sqlSession.update(Student.class.getName()+".update",s); 
			//提交事务
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//有错误需要回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	
	private void Add() throws Exception {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
		 //调用映射文件的无参数插入方法，因为sql语句里有值
			int i=sqlSession.insert(Student.class.getName()+".add");
			
			sqlSession.commit();
		} catch (Exception e) {
			e.printStackTrace();
			//出错，回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	private Student findById(int id) throws Exception {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
             Student stu = sqlSession.selectOne(Student.class.getName()+".findById", id);
			//sqlSession.commit();
             return stu;
		} catch (Exception e) {
			e.printStackTrace();
			//出错，回滚
			sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
		
	}
	private List<Student> findAll() throws Exception {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			List<Student> stusList = sqlSession.selectList(Student.class.getName()+".findAll");
			//sqlSession.commit();
			return stusList;
		} catch (Exception e) {
			e.printStackTrace();
			//出错，回滚,对于查询不需要提交事务
			//sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
		
	}
	public void delete(Student student) throws Exception {
		SqlSession sqlSession=null;
		try {
			sqlSession=MyBatisUtil.getSqlSession();
			sqlSession.update(Student.class.getName()+".delete",student);
			sqlSession.commit();
			 
		} catch (Exception e) {
			e.printStackTrace();
			//出错，回滚,对于查询不需要提交事务
			//sqlSession.rollback();
			throw e;
		}finally{
			MyBatisUtil.closeSqlSession();
		}
	}
	@Test
	public void testAdd() throws Exception{
		StudentDao dao=new StudentDao();
		dao.Add();
		}
	@Test
	public void testAddstu() throws Exception{
		StudentDao dao=new StudentDao();
		dao.Addstu(new Student(16,"pussy licker",1500));
	}
	
	@Test
	public void testFindById() throws Exception{
		int id=1;
		Student student=new StudentDao().findById(id);
		System.out.println(student);
	}
	
	@Test
	public void testFindAll() throws Exception{
		List<Student> list=new StudentDao().findAll();
		for (Student student : list) {
			System.out.println(student);
		}
	}
	
	@Test
	public void testUpdate() throws Exception{
		StudentDao dao=new StudentDao();
		Student student=dao.findById(2);
		student.setName("pauline");
		dao.update(student);
	}
	
	@Test
	public void testDelete() throws Exception{
		StudentDao dao=new StudentDao();
		Student student=dao.findById(4);
		dao.delete(student);
		System.out.println("删除了一个学生");
	}
	
}

	
