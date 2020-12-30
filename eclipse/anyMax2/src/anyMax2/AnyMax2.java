package anyMax2;

public class AnyMax2 {
   public static void main(String[] args) {
	int[] arr= {30,20,10,50,79,100,200,55,1000,777};
	int max = AnyMax2(arr);
	System.out.println("The Max Value Of this array is:" + max);
}
   public static int AnyMax2(int[] arr) {
	   int max=0;
	   for(int i=0;i<arr.length;i++) {
		   if(arr[i]>max) max=arr[i];
	   }
	  return max; 
   }
}
