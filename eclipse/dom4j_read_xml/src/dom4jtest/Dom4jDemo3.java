package dom4jtest;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jDemo3 {
    
	public static void main(String[] args) throws Exception {
	  SAXReader reader = new SAXReader();
	  Document doc=reader.read(new File("src/contact.xml"));
	  Element rootele=doc.getRootElement();
	   
//	 Element e = rootele.element("contact");//方法一
//   System.out.println(e.getName());
//	  Iterator<Element> it=rootele.elementIterator("contact");//方法二
//	  while(it.hasNext()) {
//		  Element e=it.next();
//		  //System.out.println(e.getName());
//		   //Iterator<Node> it2=e.nodeIterator();
//		   Dom4jDemo2.getChildNodes(e);
//	  }
	  //方法三
	  List<Element> list=rootele.elements();
//	  for(Element e:list) { //三<1>
//		  //System.out.println(e.getName());
//		  Dom4jDemo2.getChildNodes(e);
//	  }
	  Iterator<Element> it3 = list.iterator();//ctrl+2 松开后按l键
	  while(it3.hasNext()) {
		  Element el=it3.next();
		  Dom4jDemo2.getChildNodes(el);
	  }
   }
	
 
}
