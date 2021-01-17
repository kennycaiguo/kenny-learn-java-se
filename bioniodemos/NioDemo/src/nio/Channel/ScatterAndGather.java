package nio.Channel;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import junit.framework.Test;

public class ScatterAndGather {

	public ScatterAndGather() {
		// TODO Auto-generated constructor stub
	}

	//分散和聚集
	 
	public static  void testScatterGather() throws Exception{
			RandomAccessFile raf1 = new RandomAccessFile("IOwt.txt", "rw");
		//1. 获取通道
		FileChannel channel1 = raf1.getChannel();
		
		//2. 分配指定大小的缓冲区
		ByteBuffer buf1 = ByteBuffer.allocate(100);
		ByteBuffer buf2 = ByteBuffer.allocate(1024);
		ByteBuffer buf3= ByteBuffer.allocate(100);
		ByteBuffer buf4 = ByteBuffer.allocate(1024);
		ByteBuffer buf5 = ByteBuffer.allocate(100);
		ByteBuffer buf6 = ByteBuffer.allocate(1024);
		//3. 分散读取
		ByteBuffer[] bufs = {buf1, buf2,buf3, buf4,buf5, buf6};
		channel1.read(bufs);
		
		for (ByteBuffer byteBuffer : bufs) {
			byteBuffer.flip();
		}
		
		System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
		System.out.println("-----------------");
		System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));
		
		//4. 聚集写入
		RandomAccessFile raf2 = new RandomAccessFile("iowt2.txt", "rw");
		FileChannel channel2 = raf2.getChannel();
		
		channel2.write(bufs);
	}
	
	
	public static void main(String[] args) {
		 try {
			testScatterGather();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
