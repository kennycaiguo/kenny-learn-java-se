package com.kenny;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Niodemo {

	public Niodemo() {
		 
	}

	public static void main(String[] args) throws Exception{
		 
        // ByteBuffer buffer=ByteBuffer.allocate(20);
		//channelWriteFile();
		channelReadFile();
	}
	private static void channelReadFile() throws Exception {
		// TODO Auto-generated method stub
		FileInputStream fis =new FileInputStream("treeview.txt");
		FileChannel chan=fis.getChannel();
		
		/*
		 * File f=new File("nio.txt"); //文件位置D:\eclipseProjects\testdemo\nio.txt Path
		 * p=f.toPath(); FileChannel chan=FileChannel.open(p, StandardOpenOption.READ);
		 */
		 
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		 
		 int len=0;
		 byte[] read=new byte[1024];
		
		while ((len=chan.read(buffer))!=-1) {
			buffer.flip();//将buffer的position设置为0,一定调用这个方法否则会出现死循环
		 
			 String content=new String(buffer.array(),0,buffer.remaining());//这里一定要这样子否则结果可能不对
			 String outString=new String(content.getBytes(),"UTF-8");
			 System.out.println(outString); 
			 
		 
			buffer.clear();
		}
		chan.close();
	
		bos.close();
	}

	public static void channelWriteFile() throws Exception{
		//需求1。利用nio把一个字符串保存到一个文件里
				//(1)创建文件输出流
				FileOutputStream fos=new FileOutputStream("hello.txt");
				//(2)利用输出流创建channel
				FileChannel channel = fos.getChannel();
				//(3)调用wrap方法利用需要写入文件的内容创建buffer
				ByteBuffer buffer2=ByteBuffer.wrap("Hello world! i am using Nio!!!".getBytes());
				//（4）利用FileChannel将ByteBuffer写入文件：  
				channel.write(buffer2);
				//(5)关闭通道
				channel.close();
	}
}
