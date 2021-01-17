package com.biofileupload;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * 上传任意类型的文件给服务器保存
 * @author Administrator
 *
 */
public class UploadClient {

	public UploadClient() {
		 
	}

	public static void main(String[] args) {
		String filename="e:\\msdia80.dll";
		 String  extension =filename.substring(filename.indexOf("."));
		 System.out.println(extension);
		 try(InputStream is=new FileInputStream(filename);) {
			 //1.创建于服务器连接的socket对象
			Socket socket=new Socket("127.0.0.1",8888);
			//2.把字节输出流包装成数据输出流,它可以实现分段数据发送
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			//3.先发送上传文件的后缀给服务器
			dos.writeUTF(extension);
			//4.发送文件数据
			
			byte[] buffer=new byte[1024];
			int len=0;
			while ((len=is.read(buffer))>0) {
				dos.write(buffer,0,len);
			}
			dos.flush();
			socket.shutdownOutput();//通知服务器文件上传结束，如果没有这一句，服务器会发生异常，创建上传失败
		} catch (Exception e) {
			 
		}
	}

}
