package com.kenny;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ���̷߳�����
 * @author Administrator
 *
 */
public class BioMultiThreadSocketServer {

	public BioMultiThreadSocketServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		 //1.����ServerSocket
		ServerSocket ss=new ServerSocket(9000);
		//2.����һ����ѭ�������Ͻ��ܿͻ�������
		while (true) {
			//(1).�����ͻ���
			Socket socket = ss.accept();
			//(2)����һ���������߳�������һ���ͻ���ͨ��
			new ServerHandlerThread(socket).start();
		}
	}

}
