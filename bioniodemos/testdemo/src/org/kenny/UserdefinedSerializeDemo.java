package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class UserdefinedSerializeDemo {

	public static void main(String[] args) throws IOException {
		/*
		 * XueSheng s = new XueSheng("Jade", "Female", 19, 89.5); FileOutputStream fos =
		 * new FileOutputStream("xs.dat"); ObjectOutputStream oos = new
		 * ObjectOutputStream(fos); oos.writeObject(s); XueSheng s2 = new
		 * XueSheng("Jack", "Male", 19, 89.5);
		 * 
		 * oos.writeObject(s2); XueSheng s3 = new XueSheng("Kerry", "Female", 19, 89.5);
		 * 
		 * oos.writeObject(s3); oos.close();
		 */
		try {
			readXueSheng();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
    public static void readXueSheng() throws IOException, ClassNotFoundException {
    	FileInputStream fis=new FileInputStream("xs.dat");
		ObjectInputStream ois=new ObjectInputStream(fis);
		try {
			while(true) {
			XueSheng stu=(XueSheng) ois.readObject();
			System.out.println(stu);
			}
		} catch (EOFException e) {
			// TODO Auto-generated catch block
			System.out.println("End of file");
		}
    }
}
