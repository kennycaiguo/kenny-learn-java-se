package tcpDemo;
import java.net.*;
import java.io.*;
public class videoClient {
       public static void main(String[] args) throws IOException{
	    Socket socket=new Socket(InetAddress.getLocalHost(),9090);
	    InputStream is=socket.getInputStream();
	    byte[] buf=new byte[1024];
	    int len=0;
	    FileOutputStream fos=new FileOutputStream("e:/download.mp4");
	    while((len=is.read(buf))!=-1) {
	    	fos.write(buf,0,len);
	    }
	    fos.close();
	    socket.close();
	}
}
