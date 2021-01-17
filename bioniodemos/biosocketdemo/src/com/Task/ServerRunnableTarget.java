package com.Task;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����һ����socket��װ��Task����
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
		 //������յ��Ŀͻ���ͨ������
		try {
			  
			InputStream inputStream = socket.getInputStream();
			//1.���������ַ�������,���ж�ȡ����
			BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
			//2.��ȡ����
			String msg;
			if ((msg=br.readLine())!=null) {
				System.out.println("Message received:"+msg);
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
