package org.kenny.app2_10;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List; 
import java.util.Map;

import oracle.net.aso.b;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model; 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
 
 

@Controller
@RequestMapping(value="/emp")
public class EmpAction{
	
	  public EmpAction(){}
	  //@ResponseBody Emp表示让springmvc把emp对象转为json
	  @RequestMapping(value="/bean2json")
	  public @ResponseBody Emp bean2json() throws Exception{
		  Emp emp=new Emp();
		  emp.setId(1);
		  emp.setUsername("pussy");
		  emp.setSalary(4000.00);
		  emp.setHiredate(new Date());
		  return emp;
		  
	  }
	  @RequestMapping(value="/listbean2json")
	  public @ResponseBody List<Emp> listbean2json() throws Exception{
		   List<Emp> empList=new ArrayList<Emp>();
		   empList.add(new Emp(2,"ken",1000D,new Date()));
		   empList.add(new Emp(3,"kendall",900D,new Date()));
		   empList.add(new Emp(4,"kenlin",1300D,new Date()));
		   empList.add(new Emp(5,"kenson",1100D,new Date()));
		return empList;
		
	}
	  @RequestMapping(value="/map2json")
	  public @ResponseBody Map<String ,Object> map2json() throws Exception{
		  List<Emp> empList=new ArrayList<Emp>();
		  empList.add(new Emp(2,"ken",1000D,new Date()));
		  empList.add(new Emp(3,"kendall",900D,new Date()));
		  empList.add(new Emp(4,"kenlin",1300D,new Date()));
		  empList.add(new Emp(5,"kenson",1100D,new Date()));
		  //创建map对象
		  Map<String ,Object> map=new LinkedHashMap<String, Object>();
		   //往map中添加数据
		  map.put("total", empList.size());
		  map.put("rows", empList);
		  return map;
		  
	  }
	   
      
  }
    

