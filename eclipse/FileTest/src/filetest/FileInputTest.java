package filetest;
import java.io.*;
import java.util.Scanner;
public class FileInputTest {
    public static void main(String[] args) throws IOException {

    	BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
    	 FileWriter fw =new FileWriter("src/filetest/test.txt");
    	 BufferedWriter bw =new BufferedWriter(fw);
    	 String read=null;
    	 while((read=bfr.readLine())!=null) {
    		 if(read.length()==0) {
    			 
    			 System.out.println("Good Bye!!");
    			 break;
    		 }else {
    			     //System.out.println("writing");
		    		 bw.write(read);
		    		 bw.newLine();
		    		 bw.flush();
    		 }
    	 }
    	 
    	 bw.close();
	}
}
