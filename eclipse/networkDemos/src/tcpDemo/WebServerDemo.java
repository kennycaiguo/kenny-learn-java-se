package tcpDemo;
/*
  这是一个简单的webserver实例。webserver必须使用多线程技术
 */
import java.net.*;
import java.io.*;

public class WebServerDemo extends Thread {
	 Socket socket;
	 public WebServerDemo(Socket socket) {
		 this.socket=socket;
	 }
	 
	 public void run() {
		 try {
			OutputStream os =socket.getOutputStream();
			os.write(("<html>\n" + 
					"<head>\n" + 
					"<title>test</title>\n" + 
					"</head>\n" + 
					"<body>\n" + 
					"   <div><span>This is a Simple WebServer!!! From eclipse！！</span></div>\n" + 
					"</body>\n" + 
					"</html>").getBytes());
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	 }
    public static void main(String[] args) throws IOException {
    	ServerSocket ssocket=new ServerSocket(30000);
    	Socket socket;
    	while(true) {
    		socket=ssocket.accept();
    		new WebServerDemo(socket).start();
    	}
		 
			
	 
 
 }
}
