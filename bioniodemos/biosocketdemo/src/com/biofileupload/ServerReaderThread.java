package com.biofileupload;

import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.UUID;

public class ServerReaderThread extends Thread{
  private Socket socket;
	public ServerReaderThread() {
		 
	}
	public ServerReaderThread(Socket socket ) {
		this.socket=socket ;
	}
	
	@Override
	public void run() {
		 try {
			 //1.创建数据输入流
			 DataInputStream input=new DataInputStream(this.socket.getInputStream());
			//2.获取上传的文件类型
			 String suffix = input.readUTF();
			 System.out.println("文件到达服务器，现在开始保存...");
			 //3.定义一个输出流用于写文件
			 OutputStream os=new FileOutputStream("e:\\upload\\"+UUID.randomUUID().toString()+suffix);
		    //4.从输入流中读取文件内容写入文件
			 byte[] buf=new byte[1024];
			 int len=0;
			 while ((len=input.read(buf))>0) {
				os.write(buf,0,len);
			}
			 os.close();
			 System.out.println("文件保存成功！");
		 } catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
