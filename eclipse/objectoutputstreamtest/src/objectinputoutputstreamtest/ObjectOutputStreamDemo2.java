package objectinputoutputstreamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/*
  s这个例子演示了OjbectOutputStream的使用
 * */
class User1 implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public User1(String userName, String password) {
		 
		UserName = userName;
		Password = password;
	}
	String UserName;
	String Password;
	int age;
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "["+"UserName:" + this.UserName +"," +"Password:" +this.Password+"]";
		}
}
public class ObjectOutputStreamDemo2 {
       public static void main(String[] args) throws Exception {
 		writeObj();
    	  //readObj();
	}
	private static void writeObj() throws FileNotFoundException, IOException {
				User u1=new User("pussy","123");
				User u2=new User("bingpussy","123");
				User u3=new User("jumbopussy","123");
				ArrayList<User> list=new ArrayList<User>();
				list.add(u1);
				list.add(u2);
				list.add(u3);
		
		          File f=new File("e:/listobj.txt");
		    	  FileOutputStream fos=new FileOutputStream(f);
		    	  ObjectOutputStream oos =new ObjectOutputStream(fos);
		    	   oos.writeObject(list);
		    	   oos.close();
	}
       public static void readObj() throws Exception, Exception {
    	   File in=new File("e:/listobj.txt");
   		FileInputStream fis =new FileInputStream(in);
   		ObjectInputStream ois =new ObjectInputStream(fis);
   		Object o=ois.readObject();
   		ArrayList<User> list1=new ArrayList<User>();
   		list1=(ArrayList<User>)o;
   		 for(int i=0;i<list1.size();i++) {
   		        System.out.println(list1.get(i));
        }
       }
}
