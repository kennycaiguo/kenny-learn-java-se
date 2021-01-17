package com.kenny;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * ����һ�������������õĶ��߳���,������̳�Thread�ಢ����дrun����
 * @author Administrator
 *
 */
public class ServerHandlerThread extends Thread{
    private Socket socket;
	public ServerHandlerThread() {
		 
	}
	public ServerHandlerThread(Socket s) {
		 this.socket=s;
	}

	 @Override
		public void run() {
		 try {
			 //1.��ȡ������
			 InputStream inputStream = socket.getInputStream();
				//2.���������ַ�������,���ж�ȡ����
				BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
				//3.��ȡ����
				String msg;
				while ((msg=br.readLine())!=null) {
					System.out.println("Message received:"+msg);
				}
		} catch (Exception e) {
			// TODO: handle exception
			 
		}
		
	}

}
