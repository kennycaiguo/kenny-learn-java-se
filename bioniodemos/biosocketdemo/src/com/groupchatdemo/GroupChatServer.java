package com.groupchatdemo;

import java.util.ArrayList;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 群聊服务器
 * 服务器需求：
   1.注册端口
   2.每接受一个客户端连接，就创建一个独立的线程来处理
   3.把当前连接的客户端添加到一个在线socket集合中当前连接的客户端添加到一个在线socket集合中
   4.接收客户端发送的信息并且转发给所有在线socket客户端
 * @author Administrator
 *
 */
public class GroupChatServer {
    public static List<Socket>  onlinSockets = new ArrayList<Socket>();
	public GroupChatServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 try {
			ServerSocket serverSocket =new ServerSocket(6666);
			 while (true) {
				Socket socket =serverSocket.accept();
				//1.把连接了的的客户socket保存到一个在线集合
				onlinSockets.add(socket);
				//2.为当前连接成功的socket分配一个独立的处理线程
				new ServerReaderThread(socket).start();
				
			} 
		  } catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
