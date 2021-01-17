package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ObjectCopyDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		 // writeWorker();
		 
		 
		readWorker();
	}
	public static void writeWorker() throws FileNotFoundException, IOException {
		Worker w = new Worker("Alison", 30); 
		  FileOutputStream fos = new FileOutputStream("wk.dat");
          ObjectOutputStream oos = new ObjectOutputStream(fos); 
		  oos.writeObject(w); //��ͬһ���������л�2�Σ��ļ���ֻ��һ�����ݣ������Ҫ�������ݱ���ʹ�ÿ�¡�������Worker����뽫�����clone�����޸�Ϊpublic
		  //ʵ�ֿ�¡,ǰ����Worker�����ʵ��
		  try {
			Worker w2=(Worker) w.clone();
			oos.writeObject(w2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  oos.close();
	}
	 public static void readWorker() throws IOException, ClassNotFoundException {
	    	FileInputStream fis=new FileInputStream("wk.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			try {
				while(true) {
				Worker w=(Worker) ois.readObject();
				System.out.println(w);
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("End of file");
			}
	    }
}
