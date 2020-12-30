package tcpDemo;
import java.net.*;
import java.io.*;

public class ChatServer {
     public static void main(String[] args) throws IOException {
		ServerSocket ssocket=new ServerSocket(8080);
		Socket socket=ssocket.accept();
		OutputStreamWriter osw=new OutputStreamWriter(socket.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
		BufferedReader keyReader=new BufferedReader(new InputStreamReader(System.in));
		String line=null;
		while((line=br.readLine())!=null) {
			System.out.println("From Client:" +line);
			System.out.println("Please Enter words to reply the client:");
			line=keyReader.readLine();
			osw.write(line+"\r\n");
			osw.flush();
		}
		
		ssocket.close();
	}
}
