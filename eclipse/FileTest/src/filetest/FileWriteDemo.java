package filetest;
import java.io.*;

public class FileWriteDemo {
    public static void main(String[] args) throws Exception {
		FileWriter fw =new FileWriter("src/filetest/test.txt");
		String str="Hello,Welcome to My class!!! \r\n And Lets Write Some messages!!!";
		fw.write(str);
		fw.close();
	}
}
