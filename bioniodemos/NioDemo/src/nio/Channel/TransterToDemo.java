package nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransterToDemo {

	public TransterToDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void testTransTo() throws Exception{
		//��������ܵ�
				FileInputStream fis=new FileInputStream("1.txt");
				FileChannel inChannel=fis.getChannel();
				//��������ܵ�
				FileOutputStream fos=new FileOutputStream("4.txt");
				FileChannel outChannel=fos.getChannel();
				//���Ƶ����
				inChannel.transferTo(inChannel.position(), inChannel.size(), outChannel);
				//�رչܵ�
				inChannel.close();
				outChannel.close();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        testTransTo();
	}

}
