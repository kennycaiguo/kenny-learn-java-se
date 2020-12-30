package dom4jtest;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jDemo {
    
	public static void main(String[] args) throws Exception {
	  SAXReader reader = new SAXReader();
	  Document doc=reader.read(new File("src/contact.xml"));
	  Iterator<Node> it =doc.nodeIterator();
	 
	  while(it.hasNext()) { 
		  Node node=it.next();
		  System.out.println(node.getName());
		  if(node instanceof Element) {
			  Element el =(Element)node;
			  Iterator<Node> it2=el.nodeIterator();
			  while(it2.hasNext()) {
				  Node node2=it2.next();
				  System.out.println(node2.getName());
			  }
		  }
	  }
   }
}
