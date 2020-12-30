package tcpDemo;
import java.net.*;
import java.util.HashSet;
import java.io.*;

public class ImgServer extends Thread{
	   Socket socket;
	   static HashSet<String> ips =new HashSet<String>();
	   public ImgServer(Socket socket) {
		   this.socket=socket;
	   }
	  
	   @Override
	public void run() {
	      try {
			OutputStream os=socket.getOutputStream();
			FileInputStream fis =new FileInputStream("d:/pic/girls/girl2.jpg");
			byte[] buf=new byte[1024];
			int len=0;
			while((len=fis.read(buf))!=-1) {
				os.write(buf,0,len);
			}
			String ip =socket.getInetAddress().getHostAddress();
			if(ips.add(ip)) {
				System.out.println(ip+"Download complete,Total downloaded" +ips.size());
			}
			
			fis.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      
	}
      public static void main(String[] args) throws IOException {
		ServerSocket ssocket =new ServerSocket(9090);
		Socket socket;
		while(true) {
			socket=ssocket.accept();
			new ImgServer(socket).start();
		}
		
	}
}
