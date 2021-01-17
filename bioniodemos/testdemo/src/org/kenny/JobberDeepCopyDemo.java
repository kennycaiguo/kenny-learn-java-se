package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JobberDeepCopyDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//writeJobberDeep();
		 
		 
		readJobberDeep();
	}
	public static void writeJobberDeep() throws FileNotFoundException, IOException {
		Address addr=new Address("3 pawsey road,kgn5");
		JobberDeep jb = new JobberDeep("Alison", 30,addr); 
		  FileOutputStream fos = new FileOutputStream("jbd.dat");
          ObjectOutputStream oos = new ObjectOutputStream(fos); 
		  oos.writeObject(jb); //��ͬһ���������л�2�Σ��ļ���ֻ��һ�����ݣ������Ҫ�������ݱ���ʹ�ÿ�¡�������Worker����뽫�����clone�����޸�Ϊpublic
		  Jobber j2=(Jobber) jb.clone();
		oos.writeObject(j2);
		  oos.close();
	}
	 public static void readJobberDeep() throws IOException, ClassNotFoundException {
	    	FileInputStream fis=new FileInputStream("jbd.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			try {
				while(true) {
				JobberDeep w=(JobberDeep) ois.readObject();
				System.out.println(w);
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("End of file");
			}
	    }
}
