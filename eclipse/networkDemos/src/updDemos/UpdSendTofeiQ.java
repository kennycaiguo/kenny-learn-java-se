package updDemos;
import java.io.IOException;
/*
 这个实例演示了发送消息给feiq
 feiq的数据格式是：
 version：time：sender：ip: flag：content
 版本号：时间(System.currentTimeMillis()):发送人：ip地址(sender的ip)：32(flag默认是32）：消息内容
  
 feiq的端口号：2425
 注意：只要将ip地址改为xxx.xxx.xxx.255也就是最后一个数字是255就可以实现群发功能
 */
import java.net.*;
public class UpdSendTofeiQ {
       public static void main(String[] args) throws IOException {
    	   //prepare data to be sent
    	   String content=FormatData("hello,pussy!!!");
    	   //create socket
		   DatagramSocket socket =new DatagramSocket();
		   //create datapck
		   DatagramPacket pack=new DatagramPacket(content.getBytes(), content.getBytes().length, InetAddress.getByName("192.168.1.8"), 2425);
	       //SEND DATA
		   socket.send(pack);
		   //close socket
		   socket.close();
       }
       public static String FormatData(String content) {
    	 StringBuilder sb =new StringBuilder();
    	 sb.append("1.0 :");
    	 sb.append(System.currentTimeMillis()+" :");
    	 sb.append("kenny :");
    	 sb.append("192.168.79.1 :");
    	 sb.append("32 :");
    	 sb.append(content);
		return sb.toString();
    	   
       }
}
