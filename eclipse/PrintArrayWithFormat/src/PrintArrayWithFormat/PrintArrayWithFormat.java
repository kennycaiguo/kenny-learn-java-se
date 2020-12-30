package PrintArrayWithFormat;

public class PrintArrayWithFormat {
   public static void main(String[] args) {
	int[] arr= {30,40,50,80,12,33,45,66,8,77};
	PrintArrayWithFormat(arr);
}
   public static void PrintArrayWithFormat(int[] arr) {
	   System.out.print("[");
	   for(int i=0;i<arr.length;i++) {
		   if(i==arr.length-1) {
			   System.out.print(arr[i]+ "]");
		   }else
		   {
			   System.out.print(arr[i]+ ",");
			   
		   }
	   }
   }
}
