package com.Task;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * 这是一个伪异步IO编程实例
 * @author Administrator
 *
 */
public class TaskServer {

	public TaskServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 try {
			 //1.注册端口
			 ServerSocket ss =new ServerSocket(8000);
			 //2.使用循环接收客户端请求
			 //2.1初始化一个线程池对象
			 HandleSocketServerPool pool=new HandleSocketServerPool(3, 10);
			 while (true) {
				Socket socket =ss.accept();
				//3.把socket对象交给一个程序池
				Runnable target=new ServerRunnableTarget(socket);
				pool.excute(target);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
