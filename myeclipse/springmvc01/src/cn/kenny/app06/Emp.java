package cn.kenny.app06;

import java.util.Date;

public class Emp {
	 
    private String username;//����
    private String gender;//����
    private Date hiredate;//��ְʱ�� 
    public Emp(){}

    
	public Date getHiredate() {
		return hiredate;
	}


	public void setHiredate(Date hiredate) {
		this.hiredate = hiredate;
	}


	public Emp(String username, String gender) {
		 
		this.username = username;
		this.gender = gender;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "Emp [username=" + username + ", gender=" + gender + "]";
	}
     
}
