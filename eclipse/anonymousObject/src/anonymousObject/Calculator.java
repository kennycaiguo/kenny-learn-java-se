package anonymousObject;
import java.util.ArrayList;
import java.util.Scanner;
//import java.lang.Math; 
public class Calculator {
	 static int result=0;
    public static int calculate(String operator,int num) {
		
		ArrayList<Integer> list= new ArrayList<>();
		Scanner sc= new Scanner(System.in);
    	 for(int i=0;i<num;i++) {
    		System.out.println("Please Enter the "+(i+1)+"number:"); 
    		list.add(sc.nextInt());
    	 }
    	 switch(operator) {
    		 case "+":
    			 //int result=0;
    			 list.stream().forEach(s->{
    				result+=s; 
    				  
    			 });
    			 
    			 break;
    		 case "-":
    			  result=list.get(0);
    			 for(int i=1;i<list.size();i++) {
    				 result-=list.get(i);
    			 }
    			  
    			 break;
    		 case "*":
    			 result=1;
    			 list.stream().forEach(s->{
    				result*=s; 
    				  
    			 });
    			  
    			 break;
    		 case "/":
    			  result=list.get(0);
    			 for(int i=1;i<list.size();i++) {
    				 result/=list.get(i);
    			 }
    			  
    			 break;
    		 case "%":
    			 result=list.get(0);
    			 for(int i=1;i<list.size();i++) {
    				 result%=list.get(i);
    			 }
    			 break;
    		 
    			 
    			 	 
    	 }
    	return result;
    	
    }
}
