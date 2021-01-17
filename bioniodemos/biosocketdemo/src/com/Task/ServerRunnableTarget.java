package com.Task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个将socket封装成Task的类
 * @author Administrator
 *
 */
public class ServerRunnableTarget implements Runnable{
    private Socket socket;
	
	public ServerRunnableTarget() {
		// TODO Auto-generated constructor stub
	}

	public ServerRunnableTarget(Socket socket) {
		 this.socket=socket;
	}

	@Override
	public void run() {
		 //处理接收到的客户端通信需求
		try {
			  
			InputStream inputStream = socket.getInputStream();
			//1.构建缓冲字符输入流,按行读取数据
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			//2.读取数据
			String msg;
			if ((msg=br.readLine())!=null) {
				System.out.println("Message received:"+msg);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
