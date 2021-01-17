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
				//交给一个独立的线程来处理于客户端的交互
				new ServerReaderThread(socket).start();
			}
		} catch (Exception e) {
			 e.printStackTrace();
		}
	}

}
