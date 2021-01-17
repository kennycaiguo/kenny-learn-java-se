package nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

public class TransterToDemo {

	public TransterToDemo() {
		// TODO Auto-generated constructor stub
	}

	public static void testTransTo() throws Exception{
		//创建输入管道
				FileInputStream fis=new FileInputStream("1.txt");
				FileChannel inChannel=fis.getChannel();
				//创建输出管道
				FileOutputStream fos=new FileOutputStream("4.txt");
				FileChannel outChannel=fos.getChannel();
				//复制到输出
				inChannel.transferTo(inChannel.position(), inChannel.size(), outChannel);
				//关闭管道
				inChannel.close();
				outChannel.close();
	}
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        testTransTo();
	}

}
