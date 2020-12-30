package propertiesTest;
 import java.io.*;
 import java.util.*;
public class RuntimeCountDemo {
    public static void main(String[] args) throws IOException {
		File file =new File("e:/count.properties");
		if(!file.exists()) {
			file.createNewFile();
		}
		Properties p =new Properties();
		p.load(new FileInputStream(file));
		int count=0;
		String value=p.getProperty("count");
		if(value!=null) {
			count=Integer.parseInt(value);
		}
		if(count==3) {
			System.out.println("试用结束，请你购买正版软件...");
			System.exit(0);
		}
		count++;
		System.out.println("这是第"+count +"次使用");
		p.setProperty("count", count+"");
		p.store(new FileOutputStream(file), "Run Count");
	}
}
