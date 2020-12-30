package org.kenny.app2_08;

import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.bcel.internal.generic.NEW;

//封装user和admin对象
public class Bean {
   
  private List<Emp> empList=new ArrayList<Emp>() ;
  public Bean() {}
 
public List<Emp> getEmpList() {
	return empList;
}
public void setEmpList(List<Emp> empList) {
	this.empList = empList ;
}
 
  
}
