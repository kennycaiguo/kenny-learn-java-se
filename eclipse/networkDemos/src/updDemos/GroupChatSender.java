package updDemos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

 
/*
 群聊小程序，采用多线程技术
 */
//群聊发送端
public class GroupChatSender extends Thread {
	@Override
		public void run() {
			// TODO Auto-generated method stub
			//super.run();
		    
				try {
					DatagramSocket socket= new DatagramSocket();
					BufferedReader keyReader =new BufferedReader(new InputStreamReader(System.in));
					   String line=null;
					   DatagramPacket pack=null;
					while((line=keyReader.readLine())!=null) {
						pack=new DatagramPacket(line.getBytes(), line.getBytes().length, InetAddress.getByName("192.168.79.255"), 8080);
						socket.send(pack);
					}
   
						socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
     public static void main(String[] args) {
		
	}
}
