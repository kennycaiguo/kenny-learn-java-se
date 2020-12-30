package collecttionTest;
/*
 * eclipse  重写父类方法的快捷方式
 * 基本步骤：
 
1.需要插入Override函数的位置点击右键，选择Source->Override/Implement Methods...
 
2.选择需要添加的函数名（还可以选择“Insert Point”重新定向插入位置）
 
3.这样code里就插入了完整而准确的 Override 结构了
 * */
import java.util.ArrayList;
import java.util.Collection;
//import java.util.Collections;

public class CollectionDemo2 {
public static void main(String[] args) {
	Collection c= new ArrayList();
	c.add(new Person(1,"Dogboy"));
	c.add(new Person(2,"CatGirl"));
	c.add(new Person(3,"FishMan"));
	Object[] arr=c.toArray();
	for(int i=0;i<arr.length;i++) {
		Person p =(Person)arr[i];
		if(p.id==3) System.out.println(p.name);
	}
	//System.out.println("Has this person?"+c.contains(new Person(3,"FishMan")));
	
}
}
