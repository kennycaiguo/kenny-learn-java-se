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
		 //1.��ȡͨ��
		SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));

		//2.����Ϊ������ģʽ
		sChannel.configureBlocking(false);
		//3.���仺����
		ByteBuffer buf =ByteBuffer.allocate(1024);
		//4.�������ݵ�������
		
		Scanner scan = new Scanner(System.in);
		System.out.println("��˵��");
		while(scan.hasNext()){	
		String str = scan.nextLine();
		buf.put((new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(System.currentTimeMillis())
		+ "\n" + str).getBytes());
		buf.flip();
		sChannel.write(buf);
		buf.clear();
		}
		//�ر�ͨ��
		sChannel.close();

		
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		doClient();
	}

}
