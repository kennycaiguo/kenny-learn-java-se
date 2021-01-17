package nio.Buffer;

import java.io.BufferedWriter;
import java.nio.ByteBuffer;

import org.junit.Test;

public class BufferDemo {

	public BufferDemo() {
		// TODO Auto-generated constructor stub
	}

	@Test
	public  void test01(){
		//分配一个容量为100字节的buffer
		//ByteBuffer buffer=ByteBuffer.allocate(100);//这个用于分配非直接缓冲区（堆内存）
		ByteBuffer buffer=ByteBuffer.allocateDirect(100);//这个用于分配直接缓冲区，效率比上面高
		System.out.println(buffer.isDirect());//true
		
		getByteBufferInfo(buffer);
		System.out.println("------------------------------------------------");
		//往缓冲区中放数据
		buffer.put("Hello world!!!".getBytes());//14/100 /100
		getByteBufferInfo(buffer);
		System.out.println("------------------------------------------------");
		//使用flip方法后的信息:
		buffer.flip();
		getByteBufferInfo(buffer);//0/14/100
		System.out.println("------------------------------------------------");
		//读取内容
		byte[] b=new byte[5];
		buffer.get(b);
		System.out.println(new String(b));
		getByteBufferInfo(buffer);//5/14/100
		System.out.println("------------------------------------------------");
		//调用clear方法
		/*
		 * buffer.clear(); getByteBufferInfo(buffer); //0/100/100 buffer.get(b);
		 * System.out.println(new
		 * String(b));//调用了clear方法后，数据依然存在只是将position设置为0，limit设置为容量值
		 * System.out.println("------------------------------------------------");
		 * getByteBufferInfo(buffer);//5/100/100
		 */		
		System.out.println("------------------------------------------------");
		
		buffer.mark();//标记此刻position的值5,标记是可以回去的
		byte[] b1=new byte[6];
		buffer.get(b1);
		System.out.println(new String(b1));
		getByteBufferInfo(buffer);//11/14/100
		buffer.reset(); //回到标记位置
		getByteBufferInfo(buffer);//5/14/100
		System.out.println("------------------------------------------------");
		if(buffer.hasRemaining()) {
			System.out.println(buffer.remaining());//buffer.remaining()返回一个int值，表明还剩余第三个字符
		}
	}
	
	public void getByteBufferInfo(ByteBuffer buffer) {
		System.out.println(buffer.position()); 
		System.out.println(buffer.limit());
		System.out.println(buffer.capacity()); 
		
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
