package dom4jtest;

import java.io.File;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.Text;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class Dom4jDemo2 {
    
	public static void main(String[] args) throws Exception {
	  SAXReader reader = new SAXReader();
	  Document doc=reader.read(new File("src/contact.xml"));
	  Element rootele=doc.getRootElement();
	  getChildNodes(rootele);
   }
	
	public  static void getChildNodes(Element elem) {
		System.out.println(elem.getName()+":");
		Iterator<Node> it=elem.nodeIterator();
		while(it.hasNext()) { 
			Node  nd= it.next();
			if(nd instanceof Element) {
				Element el=(Element)nd;
				getChildNodes(el);
			}
			if(nd instanceof Text) {
				Text t =(Text)nd;
				System.out.println(t.getText());
			}
		}
	}
}
