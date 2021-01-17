package org.kenny;

import java.io.Serializable;

public class Worker implements Serializable,Cloneable{
	
    
	/**
	 * 
	 */
	private static final long serialVersionUID = -698181703344945560L;
	private String name;
    private int age;
    
    public Worker() {}
    public Worker(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

    @Override
	public String toString() {
		return "Worker [name=" + name + ", age=" + age + "]";
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}
