package com.kenny;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * 这是一个供服务器调用的多线程类,它必须继承Thread类并且重写run方法
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
			 //1.获取输入流
			 InputStream inputStream = socket.getInputStream();
				//2.构建缓冲字符输入流,按行读取数据
				BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
				//3.读取数据
				String msg;
				while ((msg=br.readLine())!=null) {
					System.out.println("Message received:"+msg);
				}
		} catch (Exception e) {
			// TODO: handle exception
			 
		}
		
	}

}
