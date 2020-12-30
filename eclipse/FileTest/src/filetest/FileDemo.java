package filetest;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileDemo {
    public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("f://test.txt");
		BufferedReader br = new BufferedReader (fr);
       String s;
      while ((s = br.readLine() )!=null) {

		    System.out.println (s);

		}
		 
		 
		fr.close();
	}
}
