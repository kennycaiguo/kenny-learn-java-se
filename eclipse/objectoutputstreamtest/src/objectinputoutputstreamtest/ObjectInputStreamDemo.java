package objectinputoutputstreamtest;
import java.io.*;

public class ObjectInputStreamDemo {
    public static void main(String[] args) throws IOException, Exception {
		File in=new File("e:/obj.txt");
		FileInputStream fis =new FileInputStream(in);
		ObjectInputStream ois =new ObjectInputStream(fis);
		Object o=ois.readObject();
		User u=(User)o;
		System.out.println(u);
	}
}
