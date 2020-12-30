package updDemos;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class GroupChatReceiver extends Thread{
    @Override
    public void run() {
    	 try {
			DatagramSocket socket=new DatagramSocket(8080);
			 byte[] buf =new byte[1024];
			 
			 DatagramPacket pack =new DatagramPacket(buf, buf.length);
			 boolean flag=true;
			 while(flag) {
				 socket.receive(pack);
				 System.out.println(pack.getAddress().getHostAddress()+"Say:"+new String(buf,0,pack.getLength()));
			 }
			 socket.close();
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
