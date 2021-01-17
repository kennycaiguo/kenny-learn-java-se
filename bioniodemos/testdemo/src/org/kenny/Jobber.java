package org.kenny;

import java.io.IOException;
import java.io.Serializable;

public class Jobber implements Serializable,Cloneable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -698181703344945560L;
	private String name;
    private int age;
    private Address addr;
    
   
	public Jobber() {}
    public Jobber(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
    public Jobber(String name, int age,Address addr) {
		super();
		this.name = name;
		this.age = age;
		this.addr=addr;
	}
    @Override
	public String toString() {
		return "Jobber [name=" + name + ", age=" + age +",address:"+this.addr+ "]";
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
	 public Address getAddr() {
			return addr;
		}
	public void setAddr(Address addr) {
			this.addr = addr;
		}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

class Address implements Serializable,Cloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String home;
	public Address() {
		
	}
    public Address(String address) {
		this.home=address;
	}
    @Override
    public String toString() {
    	// TODO Auto-generated method stub
    	return this.home;
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
    	// TODO Auto-generated method stub
    	return super.clone();
    }
}