package nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransterFromDemo {

	public TransterFromDemo() {
		// TODO Auto-generated constructor stub
	}

	public static  void testTransferFrom() throws Exception{
		//创建输入管道
		FileInputStream fis=new FileInputStream("1.txt");
		FileChannel inChannel=fis.getChannel();
		//创建输出管道
		FileOutputStream fos=new FileOutputStream("3.txt");
		FileChannel outChannel=fos.getChannel();
		//复制,输出管道从输入管道那里获取数据
		outChannel.transferFrom(inChannel, inChannel.position(), inChannel.size());
		//关闭管道
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
