package linkedlisttest;
/*
 * 该实例演示了LinkedList的用法，模拟洗牌
 * 
 * */
import java.util.LinkedList;
import java.util.Random;

class Poker{
	String color;
	String num;
	public Poker(String color, String num) {
		super();
		this.color = color;
		this.num = num;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "{"+color+num+"}";
	}
	 
	
}

public class LinkedListDemo_Poker {
   public static void main(String[] args) {
	LinkedList list=createPokers();
	shuffel_pokers(list);
	showPokers(list);
//	System.out.println(list);
//	System.out.println(list.size());
}
   public static LinkedList createPokers() {
	   LinkedList list=new LinkedList();
	   String[] colors= {"黑桃","红桃","梅花","方块"};
	   String[] nums= {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
	   for(int i=0;i<colors.length; i++) {
		   for(int j=0;j<nums.length; j++) {
			   list.add(colors[i]+nums[j]);
		   }
	   }
	return list;
	   
   }
    
   public static void showPokers(LinkedList pokers) {
	   for(int i=0;i<pokers.size();i++) {
		   System.out.print("{"+pokers.get(i)+"} ");
		   if(i%10==9) System.out.println();
	   }
   }
   
   public static void shuffel_pokers(LinkedList pokers) {
	   for(int i=0;i<100;i++) {
		   Random random=new Random();
		   int index1=random.nextInt(pokers.size());
		   int index2=random.nextInt(pokers.size());
		   pokers.set( index1, pokers.get(index2));
		   pokers.set( index2, pokers.get(index1));
	   }
   }
}
