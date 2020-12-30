package do4j211;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

public class Dom4j211xpathDemo {
	@Test
	   public void xPathTest1() throws Exception {
		   SAXReader reader=new SAXReader();
	   	Document doc=reader.read(new File("src/contact.xml"));
	   //1.根“/”：绝对路径，分层次结构到子不到孙
	   	//如："/contactList/*" 表示contactList下面的所有子标签，只有两个name标签
	   	//        "/contactList//*" 表示contactList下面的所有标签，包括孙标签
	//   Element el = (Element)doc.selectSingleNode("/contactList/contact");
	//   el.addAttribute("id", "0001");
//	   	Element nameEl=(Element)doc.selectSingleNode("/contactList/contact/name");
//	   	nameEl.setText("李嘉欣");
	//   
	   	//删除元素
//		Element nameEl=(Element)doc.selectSingleNode("/contactList/contact");
//		nameEl.detach();
	   	
	   	
	   	//2. "//" ：相对路径，不分层次结构
	   	List<Node> namesEl= doc.selectNodes("//name");
	   	for (Node element : namesEl) {
			((Element) element).addAttribute("clase", "name");
		} 
	   	//删除id为002的节点（连同子节点一起删除的）
	   	//Element nameEl=(Element)doc.selectSingleNode("//contact[@id='002']");//找到节点
	   	
	   	//Attribute attr=nameEl.attribute("id");//找到属性
	   	//nameEl.remove(attr);                        //删除属性
	   	//nameEl.detach();
	   	
	   	FileOutputStream fos=new FileOutputStream("e:/contact211.xml");
		XMLWriter writer=new XMLWriter(fos);
		writer.write(doc);
		writer.close();
	   }
}
