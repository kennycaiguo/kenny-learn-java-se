package anyMax;

public class AnyMax {
   public static void main(String[] args) {
	//int max=AnyMax(10,20,15);
	   int max=AnyMax(10,20,15,100,50);
	System.out.println("Max value is:" + max);
 }
   public static int AnyMax(int... ins) {
	   int max=0;
	   for(int i : ins) {
		   if(max<i) {
			 max=i;  
		   }
		   
	   }
	   return max;
   }
}
