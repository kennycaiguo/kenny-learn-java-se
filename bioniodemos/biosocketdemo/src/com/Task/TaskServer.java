package com.Task;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * ����һ��α�첽IO���ʵ��
 * @author Administrator
 *
 */
public class TaskServer {

	public TaskServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		 try {
			 //1.ע��˿�
			 ServerSocket ss =new ServerSocket(8000);
			 //2.ʹ��ѭ�����տͻ�������
			 //2.1��ʼ��һ���̳߳ض���
			 HandleSocketServerPool pool=new HandleSocketServerPool(3, 10);
			 while (true) {
				Socket socket =ss.accept();
				//3.��socket���󽻸�һ�������
				Runnable target=new ServerRunnableTarget(socket);
				pool.excute(target);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
