package tcpDemo;
import java.net.*;
import java.io.*;

public class TcpClient {
	public static void main(String[] args) throws Exception {
		
		Socket socket =new Socket(InetAddress.getLocalHost(), 8080);
		OutputStream os =socket.getOutputStream();
		
		os.write("Hello,server!!!!".getBytes());
		//os.close();
		InputStream is =socket.getInputStream();
		byte[] buf =new byte[1024];
		int len=is.read(buf);
		System.out.println("From Server:"+new String(buf,0,len));
		socket.close();
	}
     
}
