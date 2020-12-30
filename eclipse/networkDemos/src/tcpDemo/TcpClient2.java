package tcpDemo;
import java.net.*;
import java.io.*;

public class TcpClient2 {
	public static void main(String[] args) throws Exception {
		
		Socket socket =new Socket(InetAddress.getLocalHost(), 8080);
		OutputStream os =socket.getOutputStream();
		FileInputStream fis =new FileInputStream(new File("e:/centos1.txt"));
		InputStreamReader isr=new InputStreamReader(fis,"gbk");
	    BufferedReader reader =new BufferedReader(isr);
		String line=null;
		while((line=reader.readLine())!=null) {
			
			os.write(line.getBytes(),0,line.getBytes().length);
		}
		os.close();
		fis.close();
	}
     
}
