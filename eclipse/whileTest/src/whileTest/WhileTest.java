package whileTest;

public class WhileTest {
   public static void main(String[] args) {
	   int i=0;
	   while(i<10)
	   {
		   for(int j=0;j<=i;j++)
		   {
			   System.out.print("*");
		   }
		   System.out.print("\r\n");
		   i++;
	   }
   }
}
