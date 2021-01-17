package com.Task;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TaskClient {

	public TaskClient() {
		 
	}

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		//1.创建Socket对象
		 Socket s=new Socket("127.0.0.1",8000);
		 //2.从socket对象中获取字节输出流
		 OutputStream outputStream = s.getOutputStream();
		 //3.构建字符缓冲输出流
		 PrintStream ps=new PrintStream(outputStream);
		 Scanner sc=new Scanner(System.in);
		 String msg=null;
		 while (true) {
			 System.out.print("请说：");
			 msg=sc.nextLine();
			ps.println(msg);
			ps.flush();
		}
      
       //ps.close();
		   
		 }

}
