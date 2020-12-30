package printstreamTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

public class PrintStreamDemo {
    public static void main(String[] args) throws IOException {
    	String str="Hello ,Girls!!! How are you today!!! do you needs dicks??";
    	FileOutputStream fos=new FileOutputStream("e:/test.txt");
		PrintStream ps=new PrintStream(fos);
		ps.append(str);
		//ps.print(str);
		ps.close();
	}
}
