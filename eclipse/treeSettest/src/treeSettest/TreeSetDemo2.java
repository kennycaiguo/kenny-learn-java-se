package treeSettest;
/*
 *这个实例演示了TreeSet的用法， 如果添加到TreeSet的元素有自然顺序，那么
 *TreeSet会按照自然顺序排序。如果需要将自定义类的对象添加到TreeSet，那么
 *这个对象所属的类必须实现Comparable接口。重写public int compareTo(Object o)方法
 *如果两个对象的用于比较的值相同，则视为重复元素而不能添加到TreeSet
 *（也就是compareTo方法返回0，则视为重复元素而不能添加到TreeSet）
 * 
 * */
import java.util.TreeSet;

class Emp implements Comparable{
	int id;
	String name;
	int salary;
	
	 
	public Emp(int id, String name, int salary) {
		 
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	@Override
		public String toString() {
			// TODO Auto-generated method stub
			return "{id:" +id + "name:"+name +"salary:"+salary +"}";
		}

	@Override
	public int compareTo(Object o) {
		 Emp em=(Emp)o;
		/*
		 * if(this.salary>em.salary) { return 1; }else if(this.salary<em.salary)
		 * { return -1; }  这种方式可行
		 */ 
		return this.salary-em.salary;//更好的写法
	}
}
public class TreeSetDemo2 {
     public static void main(String[] args) {
		TreeSet tree = new TreeSet();
		tree.add(new Emp(10,"mary",100)) ;
		tree.add(new Emp(20,"may",400)) ;
	    tree.add(new Emp(30,"maria",300)) ;
		System.out.println("TreeSet的元素"+tree);
	}
}
