package propertiesTest;
/*
 注意：Properties 类的store方法有两个重载，如果要处理中文，必须使用store(writer,comment);这个方法
 也就是使用字符流操作；
 * */
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesDemo {
      public static void main(String[] args) throws IOException {
		Properties p=new Properties();
		p.setProperty("AppName", "kennyTools");
		p.setProperty("version", "1.0");
		p.setProperty("PlatForm", "windows");
		p.setProperty("dateCreated", "2019-7-10");
		p.setProperty("author", "kenny cai");
		p.store(new FileOutputStream("e:/appsetting.properties"),"Summery:");
	    p.storeToXML(new FileOutputStream("e:/app.xml"), "Contents");
      
      }
}
