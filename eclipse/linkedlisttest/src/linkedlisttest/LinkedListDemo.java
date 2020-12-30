package linkedlisttest;
/*
 * 该实例演示了LinkedList的用法，模拟堆栈，模拟队列
 * 
 * */
import java.util.LinkedList;
import java.util.Random;

 class StackList{     //模拟堆栈，后进先出
	 LinkedList list;
	 public StackList() {
		 list = new LinkedList();
	 }
	 void push(Object o) {
		 list.push(o);
	 }
	 
	 Object pop() {
		 return list.pop();
	 }
 }

 class Queue{     //模拟队列，先进先出
	 LinkedList list;
	 public Queue() {
		 list = new LinkedList();
	 }
	 
	 void add(Object o) {
		 list.offer(o);
	 }
	 
	 Object remove() {
		 return list.poll();
	 }
 }
public class LinkedListDemo {
   public static void main(String[] args) {
		/*
		 * StackList list=new StackList(); list.push("pussy");
		 * list.push("dick");
		 */
	  Queue q =new Queue();
	  q.add("vagina");
	  q.add("pussy lips");
	  System.out.println(q.remove());
	  System.out.println(q.remove());
   }
}
