package nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransterFromDemo {

	public TransterFromDemo() {
		// TODO Auto-generated constructor stub
	}

	public static  void testTransferFrom() throws Exception{
		//��������ܵ�
		FileInputStream fis=new FileInputStream("1.txt");
		FileChannel inChannel=fis.getChannel();
		//��������ܵ�
		FileOutputStream fos=new FileOutputStream("3.txt");
		FileChannel outChannel=fos.getChannel();
		//����,����ܵ�������ܵ������ȡ����
		outChannel.transferFrom(inChannel, inChannel.position(), inChannel.size());
		//�رչܵ�
		inChannel.close();
		outChannel.close();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try {
			testTransferFrom();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
