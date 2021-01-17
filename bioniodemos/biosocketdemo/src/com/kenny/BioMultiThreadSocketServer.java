package com.kenny;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 多线程服务器
 * @author Administrator
 *
 */
public class BioMultiThreadSocketServer {

	public BioMultiThreadSocketServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 //1.创建ServerSocket
		ServerSocket ss=new ServerSocket(9000);
		//2.定义一个死循环来不断接受客户端连接
		while (true) {
			//(1).监听客户端
			Socket socket = ss.accept();
			//(2)创建一个独立的线程来处理一个客户端通信
			new ServerHandlerThread(socket).start();
		}
	}

}
