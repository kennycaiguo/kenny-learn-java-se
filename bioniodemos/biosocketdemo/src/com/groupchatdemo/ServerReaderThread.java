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
    		 //1.��socket�л�ȡ�ͻ���������
    		 BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		     String msg= null;
		     while ((msg=br.readLine())!=null) {
				//2.���������յ�һ���ͻ��˵���Ϣ����Ҫ���͸��������߿ͻ���
		    	 sendMsgToAllClient(msg);
			}
		} catch (Exception e) {
			System.out.println("���������ˣ�");
			//�����߼������Ƴ���socket
			GroupChatServer.onlinSockets.remove(socket);
		}
    }

    /**
     * 
     * ʵ��Ⱥ�����ܵķ���
     * ���������յ�һ���ͻ��˵���Ϣ����Ҫ���͸��������߿ͻ���
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
