package china.kenny.app4_paging;

public class Student {
   private Integer id;
   private String name;
   private double sal;
   
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

public double getSal() {
	return sal;
}

public void setSal(double sal) {
	this.sal = sal;
}

public Student(){}

public Student(Integer id, String name, double sal) {
	 
	this.id = id;
	this.name = name;
	this.sal = sal;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sal=" + sal + "]";
}
   
   
}
