package cn.kenny.ws.socketSrv;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.sun.java.swing.plaf.windows.WindowsInternalFrameTitlePane.ScalableIconUIResource;

/**
 * socket通信服务端，实现大小写转换
 */
public class SocketSer {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss=new ServerSocket(6666);
		 boolean flag=true;
		 while (flag) { 
        //接受客户端请求
        System.out.println("监听客户端数据。。。。");
        Socket socket = ss.accept();
        //获取输入流接受客户端数据
        
		InputStream inputStream = socket.getInputStream();
		byte[] buffer=new byte[1024];
		int len=-1;
		len=inputStream.read(buffer);
		System.out.println(buffer);
		String getDataString=new String(buffer,0, len);
		//业务处理：大小写转换
	    String outString=getDataString.toUpperCase();
		//向客户输出数据
		OutputStream outputStream = socket.getOutputStream();
		outputStream.write(outString.getBytes("gbk"));
		//outputStream.close();
		//inputStream.close();
		//socket.close();
	  }
		ss.close();
	}
	

}
