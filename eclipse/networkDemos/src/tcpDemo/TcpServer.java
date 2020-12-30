package tcpDemo;
import java.net.*;
import java.io.*;

public class TcpServer {
    public static void main(String[] args) throws Exception {
		ServerSocket ssocket =new ServerSocket(8080);
		Socket socket=ssocket.accept();
		InputStream is=socket.getInputStream();
		byte[] buf=new byte[1024];
		int len=0;
		 
			System.out.println(new String(buf,0,len));
		 
		//is.close();
		OutputStream os=socket.getOutputStream();
		os.write("Thank you,Client!!!".getBytes());
		ssocket.close(); 
	}
}
