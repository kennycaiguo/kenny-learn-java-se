package systemDemo;
/*
 * System.arraycopy(arr, 1, newarr, 0, newarr.length);
 *  Properties pps =System.getProperties();
	  pps.list(System.out);
 * 
 * 
 * */
import java.util.Arrays;
import java.util.Properties;
 

public class SystemDemo {
  public static void main(String[] args) {
//	int[] arr= {12,10,9,33,45,23};
//	int[] newarr =new int[4];
//	System.arraycopy(arr, 1, newarr, 0, newarr.length);
//	System.out.println(Arrays.toString(newarr));
//	
//	  
//	  Properties pps =System.getProperties();
//	  pps.list(System.out);
	  
	  String p =System.getProperty("os.name");
	  System.out.println(p);
}
}
