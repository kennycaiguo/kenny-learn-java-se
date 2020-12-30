package objectinputoutputstreamtest;
import java.io.*;
import java.util.ArrayList;

public class ObjectInputStreamDemo2 {
    public static void main(String[] args) throws IOException, Exception {
	  readObj();
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
