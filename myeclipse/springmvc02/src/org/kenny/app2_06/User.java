package org.kenny.app2_06;

import java.util.Date;

public class User {
	
	//private Integer id=0;//编号
	private String username;//姓名
	private Double salary;//工资
    private Date hiredate;//入职时间
    
	public User() {
		 
	}
	/*public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}*/
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
	public Date getHiredate() {
		return hiredate;
	}
	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}
	@Override
	public String toString() {
		return "User [ username=" + username + ", salary="
				+ salary + ", hiredate=" + hiredate + "]";
		/*return "User [id=" + id + ", username=" + username + ", salary="
		+ salary + ", hiredate=" + hiredate + "]";*/
	}
    
}
