package updDemos;
import java.io.IOException;
import java.net.*;
public class Updsender {
    public static void main(String[] args) throws IOException {
		//创建socket
    	DatagramSocket dgsocket=new DatagramSocket();
    	//创建数据包
    	String str="Hello,girls! how are u? I want to Fuck pussies!!!";
    	DatagramPacket dgpack=new DatagramPacket(str.getBytes(), str.getBytes().length, InetAddress.getLocalHost(), 8080);
    	//发送数据包
    	dgsocket.send(dgpack);
    	//关闭资源
    	dgsocket.close();
	}
}
