package com.groupchatdemo;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Iterator;

public class ServerReaderThread extends Thread{
    private Socket socket ;
    
	public ServerReaderThread() {
		// TODO Auto-generated constructor stub
	}
    
	public ServerReaderThread(Socket socket ) {
		this.socket=socket ;
	}
	
    @Override
    public void run() {
    	 try {
    		 //1.从socket中获取客户端输入流
    		 BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     String msg= null;
		     while ((msg=br.readLine())!=null) {
				//2.服务器接收到一个客户端的信息，需要推送给所有在线客户端
		    	 sendMsgToAllClient(msg);
			}
		} catch (Exception e) {
			System.out.println("有人下线了！");
			//从在线集合中移除本socket
			GroupChatServer.onlinSockets.remove(socket);
		}
    }

    /**
     * 
     * 实现群发功能的方法
     * 服务器接收到一个客户端的信息，需要推送给所有在线客户端
     * @param msg
     */
	private void sendMsgToAllClient(String msg) throws Exception{
	   for (Socket s :GroupChatServer.onlinSockets) {
		      PrintStream ps=new PrintStream(s.getOutputStream());
		      ps.print(msg);
		      ps.flush();
	 }
	}
}
