package dom4jtest;

public class Contact {
	
    private  String id;
    private String name;
    private String age;
    private String phone;
    private String email;
    private String qq;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getQq() {
		return qq;
	}
	public void setQq(String qq) {
		this.qq = qq;
	}
    
     @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return  "["+"Id:"+this.id +","+"Name:"+this.name +","+"age:"+this.age +","+"Phone:"+this.phone+","+"Email:"+this.email +","+"QQ:"+this.qq +"]";
    }
}
