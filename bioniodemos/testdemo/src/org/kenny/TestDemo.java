package org.kenny;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

 
public class TestDemo {

	public static void main(String[] args) throws IOException, Exception {
		Student s = new Student("Jade", "Female", 19, 89.5);
		FileOutputStream fos = new FileOutputStream("stu.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(s);
		Student s2 = new Student("Jack", "Male", 19, 89.5);
		 
		oos.writeObject(s2);
		Student s3 = new Student("Kerry", "Female", 19, 89.5);
		 
		oos.writeObject(s3);
		oos.close();
//		FileInputStream fis=new FileInputStream("stu.dat");
//		ObjectInputStream ois=new ObjectInputStream(fis);
//		Student stu=(Student) ois.readObject();
//		System.out.println(stu);
//		ois.close();
	}

}
