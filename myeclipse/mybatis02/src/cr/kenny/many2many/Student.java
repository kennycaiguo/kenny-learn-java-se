package cr.kenny.many2many;

import java.util.ArrayList;
import java.util.List;

 

//多方
public class Student {
   private Integer id;
   private String name;
   private List<Course> courseList=new ArrayList<Course>();//关联属性
   
   public Student(){}

 

public Student(Integer id, String name) {
	
	this.id = id;
	this.name = name;
	//this.courseList = courseList;
}



public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

 

 
public List<Course> getCourseList() {
	return courseList;
}

public void setCourseList(List<Course> courseList) {
	this.courseList = courseList;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + "]";
}
   
}
