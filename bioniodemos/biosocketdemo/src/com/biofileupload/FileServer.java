package com.biofileupload;

import java.net.ServerSocket;
import java.net.Socket;

public class FileServer {

	public FileServer() {
		 
	}

	public static void main(String[] args) {
		 try {
			ServerSocket ss=new ServerSocket(8888);
			while (true) {
				Socket socket = ss.accept();
				//����һ���������߳��������ڿͻ��˵Ľ���
				new ServerReaderThread(socket).start();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
