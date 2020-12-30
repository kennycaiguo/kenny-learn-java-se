package enhancedforloop;

import java.util.ArrayList;
import java.util.HashSet;

/*
 * 增强for循环，可以遍历所有实现了Iterable<T>接口 的类如set，list，数组等等
 * 还可以使用可变参数

 * 
 * */
public class EnhancedForDemo {
	public static void main(String[] args) {
		 ArrayList<String>  list1=new ArrayList <String>( );
		//HashSet<String> list1 =new HashSet<>();
		 list1.add("lips");
		 list1.add("breast");
		 list1.add("pussy");
		 list1.add("asshole");
		 
		 for(String item : list1) {
			 System.out.println("Element:" + item);
		 }
		//数组也可以使用增强for
//		String[] orgs= {"lips","pussy","breast","vagina","pussy hole"};
//		for(String item : orgs) {
//			System.out.println("Organ:"+ item);
//		}
		
	}
  
  
}
