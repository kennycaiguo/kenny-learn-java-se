package org.kenny;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class JobberShallowCopyDemo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		 //writeJobber();
		 
		 
		readJobber();
	}
	public static void writeJobber() throws FileNotFoundException, IOException {
		Address addr=new Address("3 pawsey road,kgn5");
		Jobber jb = new Jobber("Alison", 30,addr); 
		  FileOutputStream fos = new FileOutputStream("jb.dat");
          ObjectOutputStream oos = new ObjectOutputStream(fos); 
		  oos.writeObject(jb); //将同一个对象序列化2次，文件中只有一份数据，如果想要两份数据必须使用克隆来解决，Worker类必须将父类的clone方法修改为public
		  //实现克隆,前提是Worker类必须实现
		  try {
			Jobber j2=(Jobber) jb.clone();
			oos.writeObject(j2);
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  oos.close();
	}
	 public static void readJobber() throws IOException, ClassNotFoundException {
	    	FileInputStream fis=new FileInputStream("jb.dat");
			ObjectInputStream ois=new ObjectInputStream(fis);
			try {
				while(true) {
				Jobber w=(Jobber) ois.readObject();
				System.out.println(w);
				}
			} catch (EOFException e) {
				// TODO Auto-generated catch block
				System.out.println("End of file");
			}
	    }
}
