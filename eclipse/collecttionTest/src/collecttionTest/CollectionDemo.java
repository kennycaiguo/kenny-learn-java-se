package collecttionTest;
/* 
eclipse中查看jdk源代码

文章分类:Java编程

1，你把鼠标放在一个jdk的类上按下F3，如果这时迁移到一个class文件拿去的话 
2，class文件画面会有一个“关联源代码”按钮，点击这个按钮，然后从系统文件选择jdk下的src.zip文件 
这样就ok了，以后你就可以直接看到源码了。
 
 * eclipse  重写父类方法的快捷方式
 * 基本步骤：
 
1.需要插入Override函数的位置点击右键，选择Source->Override/Implement Methods...
 
2.选择需要添加的函数名（还可以选择“Insert Point”重新定向插入位置）
 
3.这样code里就插入了完整而准确的 Override 结构了
 * */
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collections;

class Person{
	public Person(int id, String name) {
		 
		this.id = id;
		this.name = name;
	}
	
	 
	@Override
	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		Person p =(Person)o;
		return this.id==p.id;
	}

 
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}

	 

	int id;
	String name;
}
public class CollectionDemo {
public static void main(String[] args) {
	Collection c= new ArrayList();
	c.add(new Person(1,"Dogboy"));
	c.add(new Person(2,"CatGirl"));
	c.add(new Person(3,"FishMan"));
	
	System.out.println("Has this person?"+c.contains(new Person(3,"FishMan")));
	
}
}
