package updDemos;
import java.io.IOException;
import java.net.*;
import java.util.Arrays;
public class netdemo1 {
   public static void main(String[] args) throws IOException {
	InetAddress inet=InetAddress.getLocalHost();
	String addr=inet.getHostAddress();
	System.out.println(addr);
	System.out.println("Host Name:"+inet.getHostName());
	//InetAddress[] inet2 =InetAddress.getAllByName("WIN-5C4763I7IR8" );//获取指定主机的所有ip地址，参数可以是主机名，ip地址，还可以是域名
	InetAddress[] inet2 =InetAddress.getAllByName("www.baidu.com" );//获取指定主机的所有ip地址，参数可以是主机名，ip地址，还可以是域名
	System.out.println("host IP:" +Arrays.toString(inet2));
	
 }
}
