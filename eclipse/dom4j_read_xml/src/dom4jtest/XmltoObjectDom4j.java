package dom4jtest;
/*/
 * 
 * xml的实际应用就是如下；
 */
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class XmltoObjectDom4j {
   public static void main(String[] args) throws Exception {
	   List<Contact> list =new ArrayList<Contact>();
	SAXReader reader=new SAXReader();
	Document doc=reader.read(new File("src/contact.xml"));
	 Element rootEl=doc.getRootElement();
	 Iterator<Element> it =rootEl.elementIterator("contact");
	 while(it.hasNext()) {
		 Element e=it.next();
		 Contact contact=new Contact();
		 contact.setId(e.attributeValue("id"));
		 contact.setName(e.elementText("name"));
		 contact.setAge(e.elementText("age"));
		 contact.setPhone(e.elementText("phone"));
		 contact.setEmail(e.elementText("email"));
		 contact.setQq(e.elementText("qq"));
		 list.add(contact);
	 }
	 
	 for(Contact c:list) {
		 System.out.println(c);
	 }
 }
}
