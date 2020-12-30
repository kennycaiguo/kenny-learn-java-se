package updDemos;
import java.io.IOException;
import java.net.*;

public class ReceiveFromFeiQ {
    public static void main(String[] args) throws IOException {
    	  // 创建socket并且要监听端口
 	   DatagramSocket dgsocket=new DatagramSocket(2425,InetAddress.getByName("192.168.1.8"));
 	   //准备空的数据包用于存放数据
 	   byte[] buf=new byte[1024];
 	   DatagramPacket dgpack=new DatagramPacket(buf, buf.length);
 	  // 接收数据
        dgsocket.receive(dgpack);
        
        System.out.println("data received:"+new String(buf,0,dgpack.getLength()));
    	//关闭资源
    	dgsocket.close();
	}
}
