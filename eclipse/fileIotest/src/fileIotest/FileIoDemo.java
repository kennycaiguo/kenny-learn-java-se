package fileIotest;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileIoDemo {
	public static void main(String[] args) {
//		 File file =new File("e:/hello.txt");
//		 System.out.println("File exists?" +file.exists());
//		 try {
//			if(file.createNewFile()) {
//				file.setWritable(true);
//			FileWriter write =new FileWriter(file);
//			 BufferedWriter writer=new BufferedWriter(write);
//			 writer.write("hello, big pussy girls!!!");
//			 writer.flush();
//			 writer.close();
//			 write.close();
//			 
//			 }
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		FileWriter write;
		try {
			write = new FileWriter("e:/hello.txt");
			BufferedWriter writer=new BufferedWriter(write);
			 writer.write("hello, big pussy girls!!!");
			 writer.flush();
			 writer.close();
			 write.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
	}
   
   
}
