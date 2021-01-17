package org.kenny;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
//这是一个用于实现深拷贝的类
public class JobberDeepBArr extends Jobber implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -698181703344945560L;

	public JobberDeepBArr() {
	}

	public JobberDeepBArr(String name, int age, Address addr) {
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
		ByteArrayOutputStream bos=null;
		ObjectOutputStream oos=null;
		ByteArrayInputStream bis =null;
		ObjectInputStream ois=null;
		JobberDeepBArr jd=null;
		try {
			bos =new ByteArrayOutputStream();
			 oos=new ObjectOutputStream(bos);
			
			oos.writeObject(this);
			byte[] bs=bos.toByteArray();
			oos.close();
			//byte[] buf=new byte[1024];
			  bis =new ByteArrayInputStream(bs);
			  ois =new ObjectInputStream(bis);
			jd=(JobberDeepBArr)ois.readObject();
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