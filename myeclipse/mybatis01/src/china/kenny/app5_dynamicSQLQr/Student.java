package china.kenny.app5_dynamicSQLQr;

public class Student {
   private Integer id;
   private String name;
   private Double sal;
   
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

public Student(){}

public Student(Integer id, String name, Double sal) {
	 
	this.id = id;
	this.name = name;
	this.sal = sal;
}

@Override
public String toString() {
	return "Student [id=" + id + ", name=" + name + ", sal=" + sal + "]";
}
   
   
}
