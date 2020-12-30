package kenny.app;

import java.util.UUID;

public class Emp {
	
   private String id;
   private String username;
   private Double salary;
   public Emp(){};
   
public Emp(String id, String username, Double salary) {
	 
	this.id = id;
	this.username = username;
	this.salary = salary;
}

public Emp(String name, Double sal) {
	// TODO Auto-generated constructor stub
	this.username=name;
	this.salary=sal;
	
}

public String getId() {
	return UUID.randomUUID().toString();
}
public void setId(String id) {
	this.id = id;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public Double getSalary() {
	return salary;
}
public void setSalary(Double salary) {
	this.salary = salary;
}
@Override
public String toString() {
	return "Emp [id=" + id + ", username=" + username + ", salary=" + salary
			+ "]";
}
   
}
