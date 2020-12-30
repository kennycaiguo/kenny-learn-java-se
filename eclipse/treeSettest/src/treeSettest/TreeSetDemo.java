package treeSettest;
/*
 *这个实例演示了TreeSet的用法， 如果添加到TreeSet的元素有自然顺序，那么
 *TreeSet会按照自然顺序排序。
 *
 * 
 * */
import java.util.TreeSet;

public class TreeSetDemo {
     public static void main(String[] args) {
		TreeSet tree = new TreeSet();
		/*
		 * tree.add("pussy"); tree.add("dick"); tree.add("vagina");
		 * tree.add("breast"); tree.add("lips");
		 */
		tree.add(9);
		tree.add(1);
		tree.add(5);
		tree.add(4);
		
		
		System.out.println("TreeSet的元素"+tree);
	}
}
