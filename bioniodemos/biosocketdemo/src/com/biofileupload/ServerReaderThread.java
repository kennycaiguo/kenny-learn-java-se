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
			 //1.��������������
			 DataInputStream input=new DataInputStream(this.socket.getInputStream());
			//2.��ȡ�ϴ����ļ�����
			 String suffix = input.readUTF();
			 System.out.println("�ļ���������������ڿ�ʼ����...");
			 //3.����һ�����������д�ļ�
			 OutputStream os=new FileOutputStream("e:\\upload\\"+UUID.randomUUID().toString()+suffix);
		    //4.���������ж�ȡ�ļ�����д���ļ�
			 byte[] buf=new byte[1024];
			 int len=0;
			 while ((len=input.read(buf))>0) {
				os.write(buf,0,len);
			}
			 os.close();
			 System.out.println("�ļ�����ɹ���");
		 } catch (Exception e) {
			 e.printStackTrace();
		}
	}
}
