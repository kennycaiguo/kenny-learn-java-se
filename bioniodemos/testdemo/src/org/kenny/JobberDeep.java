package org.kenny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//这是一个用于实现深拷贝的类
public class JobberDeep extends Jobber implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698181703344945560L;

	public JobberDeep() {
	}

	public JobberDeep(String name, int age, Address addr) {
		super(name, age, addr);

	}

	@Override
	public String toString() {
		return super.toString();
	}

	@Override
	public Object clone() {
		// TODO Auto-generated method stub
		 //深拷贝，需要重写父类的clone处理逻辑
		FileOutputStream fos=null;
		ObjectOutputStream oos=null;
		FileInputStream fis =null;
		ObjectInputStream ois=null;
		JobberDeep jd=null;
		try {
			fos =new FileOutputStream("data.dat");
			 oos=new ObjectOutputStream(fos);
			
			oos.writeObject(this);
			oos.close();
			  fis =new FileInputStream("data.dat");
			  ois =new ObjectInputStream(fis);
			jd=(JobberDeep)ois.readObject();
		} catch (Exception e) {
			// TODO: handle exception
		}
	     
		return jd;
	}
}

/*
 * class Address implements Serializable,Cloneable{
 *//**
	* 
	*//*
		 * private static final long serialVersionUID = 1L; String home; public
		 * Address() {
		 * 
		 * } public Address(String address) { this.home=address; }
		 * 
		 * @Override public String toString() { // TODO Auto-generated method stub
		 * return this.home; }
		 * 
		 * @Override public Object clone() throws CloneNotSupportedException { // TODO
		 * Auto-generated method stub return super.clone(); } }
		 */