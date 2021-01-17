package nio.Selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class SelectorClient {

	public SelectorClient() {
		// TODO Auto-generated constructor stub
	}
    
	public static void doClient() throws Exception{
		 //1.获取通道
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		//2.设置为非阻塞模式
		sChannel.configureBlocking(false);
		//3.分配缓冲区
		ByteBuffer buf =ByteBuffer.allocate(1024);
		//4.发送数据到服务器
		
		Scanner scan = new Scanner(System.in);
		System.out.println("请说：");
		while(scan.hasNext()){	
		String str = scan.nextLine();
		buf.put((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis())
		+ "\n" + str).getBytes());
		buf.flip();
		sChannel.write(buf);
		buf.clear();
		}
		//关闭通道
		sChannel.close();

		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		doClient();
	}

}
