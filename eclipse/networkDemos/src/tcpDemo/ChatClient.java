package tcpDemo;
/*
  注意： BufferedReader的readLine()方法如果没有"\r\n",就不会认为读到了一行。这样就会导致server收不到消息
 */
import java.net.*;
import java.io.*;
public class ChatClient {
     public static void main(String[] args) throws Exception{
		Socket socket =new Socket(InetAddress.getByName("192.168.79.1"),8080);
		OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
		
		BufferedReader keyReader=new BufferedReader(new InputStreamReader(System.in));
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String line=null;
		while((line=keyReader.readLine())!=null) {
			osw.write(line+"\r\n");
			osw.flush();
			line=br.readLine();
			System.out.println("Server Replied:"+ line);
		}
		socket.close();
	}
}
