package recursive;
/*
 利用递归计算一个数的阶乘
 */
public class RecursiveDemo1 {
   public static void main(String[] args) {
	int result=recursiveMultiply(3);
	System.out.println("你输入的数的阶乘="+result);
 }
   public static int recursiveMultiply(int num) {
	    
	   if(num==1) {
		   return 1;
	   }
	   return num*recursiveMultiply(num-1);
	   
	   
   }
}
