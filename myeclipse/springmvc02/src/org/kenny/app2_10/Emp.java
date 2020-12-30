package org.kenny.app2_10;

import java.util.Date;
import java.util.UUID;

public class Emp {
	 
    private Integer id;
	private String username;//用户名
	private Double salary;//薪水
    private Date hiredate;//入职时间
    public Emp(){}
 
	public Emp(Integer id, String username, Double salary, Date hiredate) {
		 
		this.id = id;
		this.username = username;
		this.salary = salary;
		this.hiredate = hiredate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	 

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getHiredate() {
		return hiredate;
	}

	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "[Emp username=" + username + ", salary=" + salary + "]";
	}

    
	 
}
