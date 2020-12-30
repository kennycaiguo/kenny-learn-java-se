package hello.appdemo1;

//该程序演示了如何从键盘输入字符串
import java.io.*;
public class hello {
     public static void main(String[] args) throws IOException
     {
    	 BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
         String str = null; 
         System.out.println("Enter your value:"); 
         str = br.readLine(); 
         System.out.println("your value is :"+str); 
     }
}
