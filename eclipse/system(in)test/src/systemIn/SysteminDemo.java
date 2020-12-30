package systemIn;

import java.io.IOException;
import java.io.InputStream;

public class SysteminDemo {
    public static void main(String[] args) throws IOException {
		readTest();
	}
     
    public static void readTest() throws IOException {
    	InputStream in =System.in;
    	System.out.println("Please Enter data");
    	byte[] buf=new byte[1024];
    	in.read(buf);
    	System.out.println("data read is:"+new String(buf));
    }
    		
}
