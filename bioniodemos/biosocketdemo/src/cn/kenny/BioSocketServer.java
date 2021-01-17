package cn.kenny;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * 同步阻塞案例
 * @author Administrator
 *
 */
public class BioSocketServer {
	
      
	public BioSocketServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //1.创建ServerSocket
		ServerSocket ss=new ServerSocket(9000);
		//2.监听客户端
		Socket socket = ss.accept();
		//3.从socket中获取字节输入流
		InputStream inputStream = socket.getInputStream();
		//4.构建缓冲字符输入流,按行读取数据
		BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
		//5.读取数据
		String msg;
		if ((msg=br.readLine())!=null) {
			System.out.println("Message received:"+msg);
		}
		
	}

}
