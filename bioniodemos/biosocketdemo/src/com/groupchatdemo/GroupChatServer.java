package com.groupchatdemo;

import java.util.ArrayList;
import java.util.List;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Ⱥ�ķ�����
 * ����������
   1.ע��˿�
   2.ÿ����һ���ͻ������ӣ��ʹ���һ���������߳�������
   3.�ѵ�ǰ���ӵĿͻ�����ӵ�һ������socket�����е�ǰ���ӵĿͻ�����ӵ�һ������socket������
   4.���տͻ��˷��͵���Ϣ����ת������������socket�ͻ���
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
				//1.�������˵ĵĿͻ�socket���浽һ�����߼���
				onlinSockets.add(socket);
				//2.Ϊ��ǰ���ӳɹ���socket����һ�������Ĵ����߳�
				new ServerReaderThread(socket).start();
				
			} 
		  } catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
