package zmt.kenny.entity;

public class Emp {
	
   private Integer id;
   private String name;
   private Double sal;
   private String sex;
   
   public Emp(){}

 public Emp(Integer id, String name, Double sal, String sex) {
	 
	this.id = id;
	this.name = name;
	this.sal = sal;
	this.sex = sex;
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

public Double getSal() {
	return sal;
}

public void setSal(Double sal) {
	this.sal = sal;
}

public String getSex() {
	return sex;
}

public void setSex(String sex) {
	this.sex = sex;
}

@Override
public String toString() {
	return "Emp [id=" + id + ", name=" + name + ", sal=" + sal + ", sex=" + sex
			+ "]";
}
   
   
}
