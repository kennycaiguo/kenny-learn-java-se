package collecttionTest;
/*
 * eclipse  重写父类方法的快捷方式
 * 基本步骤：
 
1.需要插入Override函数的位置点击右键，选择Source->Override/Implement Methods...
 
2.选择需要添加的函数名（还可以选择“Insert Point”重新定向插入位置）
 
3.这样code里就插入了完整而准确的 Override 结构了

中国例子演示iterator方法的使用接口 Iterator只有三种方法
方法摘要 
 boolean hasNext() 
          如果仍有元素可以迭代，则返回 true。 
 E next() 
          返回迭代的下一个元素。 
 void remove() 
          从迭代器指向的 collection 中移除迭代器最后一次返回的元素（可选操作）。 
  

 * */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
//import java.util.Collections;

public class CollectionDemo3 {
public static void main(String[] args) {
	Collection c= new ArrayList();
	c.add(new Person(1,"Dogboy"));
	c.add(new Person(2,"CatGirl"));
	c.add(new Person(3,"FishMan"));
	//Object[] arr=c.toArray();
	 Iterator i=c.iterator();
	 while(i.hasNext()) {
		 Person p=(Person)i.next();
		 System.out.println(p.name);
	 }
	//System.out.println("Has this person?"+c.contains(new Person(3,"FishMan")));
	
}
}
