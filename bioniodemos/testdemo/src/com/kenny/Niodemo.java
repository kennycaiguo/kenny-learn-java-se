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
		 * File f=new File("nio.txt"); //�ļ�λ��D:\eclipseProjects\testdemo\nio.txt Path
		 * p=f.toPath(); FileChannel chan=FileChannel.open(p, StandardOpenOption.READ);
		 */
		 
		ByteBuffer buffer=ByteBuffer.allocate(1024);
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		 
		 int len=0;
		 byte[] read=new byte[1024];
		
		while ((len=chan.read(buffer))!=-1) {
			buffer.flip();//��buffer��position����Ϊ0,һ�����������������������ѭ��
		 
			 String content=new String(buffer.array(),0,buffer.remaining());//����һ��Ҫ�����ӷ��������ܲ���
			 String outString=new String(content.getBytes(),"UTF-8");
			 System.out.println(outString); 
			 
		 
			buffer.clear();
		}
		chan.close();
	
		bos.close();
	}

	public static void channelWriteFile() throws Exception{
		//����1������nio��һ���ַ������浽һ���ļ���
				//(1)�����ļ������
				FileOutputStream fos=new FileOutputStream("hello.txt");
				//(2)�������������channel
				FileChannel channel = fos.getChannel();
				//(3)����wrap����������Ҫд���ļ������ݴ���buffer
				ByteBuffer buffer2=ByteBuffer.wrap("Hello world! i am using Nio!!!".getBytes());
				//��4������FileChannel��ByteBufferд���ļ���  
				channel.write(buffer2);
				//(5)�ر�ͨ��
				channel.close();
	}
}
