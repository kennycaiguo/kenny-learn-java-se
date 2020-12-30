package beanutildemo;

import java.util.Date;

public class Admin {
    private String name;
    private String pwd;
    private String age;
	private Date birth;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	 
	public Date getBirth() {
		return birth;
	}
	public void setBirth(Date birth) {
		this.birth = birth;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Admin [name=" + name + ", pwd=" + pwd + ", age=" + age + ", birth=" + birth + "]";
	}
	 
}
