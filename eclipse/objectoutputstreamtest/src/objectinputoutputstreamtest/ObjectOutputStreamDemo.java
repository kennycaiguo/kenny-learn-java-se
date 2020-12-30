package objectinputoutputstreamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
  s这个例子演示了OjbectOutputStream的使用
 * */
class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User(String userName, String password) {
		 
		UserName = userName;
		Password = password;
	}
	String UserName;
	String Password;
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+"UserName:" + this.UserName +"," +"Password:" +this.Password+"]";
		}
}
public class ObjectOutputStreamDemo {
       public static void main(String[] args) throws Exception {
 		//writeObj();
    	  readObj();
	}
	private static void writeObj() throws FileNotFoundException, IOException {
		User u=new User("pussy","123");
           File f=new File("e:/obj.txt");
    	   FileOutputStream fos=new FileOutputStream(f);
    	   ObjectOutputStream oos =new ObjectOutputStream(fos);
    	   oos.writeObject(u);
    	   oos.close();
	}
       public static void readObj() throws Exception, Exception {
    	   File in=new File("e:/obj.txt");
   		FileInputStream fis =new FileInputStream(in);
   		ObjectInputStream ois =new ObjectInputStream(fis);
   		Object o=ois.readObject();
   		User u=(User)o;
   		System.out.println(u);
       }
}
