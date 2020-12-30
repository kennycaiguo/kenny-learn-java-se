package soy.kenny.service.impl;

import java.util.Iterator;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

import soy.kenny.dao.impl.EmpDao;
import soy.kenny.dao.inter.IEmpDao;
import soy.kenny.entity.Emp;
import soy.kenny.entity.Page;
import soy.kenny.service.inter.IEmpService;

public class EmpService implements IEmpService {
	
    private IEmpDao iEmpDao=new EmpDao() ;
    
	public IEmpDao getiEmpDao() {
		return iEmpDao;
	}

	public void setiEmpDao(IEmpDao iEmpDao) {
		this.iEmpDao = iEmpDao;
	}

	public Page show(int currPageNO) throws Exception {
		  Page page=new Page();
		  //封装当前页号
		  page.setCurrPageNO(currPageNO);
		  
		  //封装总记录数
		  Integer allRecordNO=iEmpDao.getAllRecord();
		  page.setAllRecordNO(allRecordNO);
		  //计算总页数
		  Integer allPageNO= null;
		  if(page.getAllRecordNO()%page.getPerPageSize()==0){
			  allPageNO=page.getAllRecordNO()/page.getPerPageSize();
		  }else{
			  allPageNO=page.getAllRecordNO()/page.getPerPageSize()+1;
			  
		  }
				  
		  page.setAllPageNO(allPageNO);
		int start=(page.getCurrPageNO()-1)*page.getPerPageSize();
		int end=page.getCurrPageNO()*page.getPerPageSize()+1;
		List<Emp> empList=iEmpDao.findAllRecord(start, end);
		  page.setEmpList(empList);
		return page;
	}

	public static void main(String[] args) throws Exception {
		EmpService empService=new EmpService();
		System.out.println("----------------------------------------------no1");
		Page page = empService.show(1);
		 for (Emp e :page.getEmpList()) {
			System.out.println(e);
		}
		 System.out.println("----------------------------------------------no2");
		  page = empService.show(2);
		 for (Emp e :page.getEmpList()) {
			 System.out.println(e);
		 }
		 System.out.println("----------------------------------------------no3");
		 page = empService.show(3);
		 for (Emp e :page.getEmpList()) {
			 System.out.println(e);
		 }
		 System.out.println("----------------------------------------------no4");
		 page = empService.show(4);
		 for (Emp e :page.getEmpList()) {
			 System.out.println(e);
		 }
		 System.out.println("----------------------------------------------no5");
		 page = empService.show(5);
		 for (Emp e :page.getEmpList()) {
			 System.out.println(e);
		 }
	}
}
