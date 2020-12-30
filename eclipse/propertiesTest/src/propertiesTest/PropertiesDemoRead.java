package propertiesTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;

public class PropertiesDemoRead {
      public static void main(String[] args) throws IOException {
    	  Properties p=new Properties();
		//p.load(new FileInputStream("e:/appsetting.properties"));
    	  p.loadFromXML(new FileInputStream("e:/app.xml"));
		//String author=p.getProperty("author");获取单一属性；
		
	   Set<Entry<Object, Object>> set =p.entrySet();
	    for(Entry entry : set) {
	    	System.out.println("Key=="+entry.getKey()+" : "+"value==" +entry.getValue());
	   
	    }
 
      }
}
