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
		//����һ������Ϊ100�ֽڵ�buffer
		//ByteBuffer buffer=ByteBuffer.allocate(100);//������ڷ����ֱ�ӻ����������ڴ棩
		ByteBuffer buffer=ByteBuffer.allocateDirect(100);//������ڷ���ֱ�ӻ�������Ч�ʱ������
		System.out.println(buffer.isDirect());//true
		
		getByteBufferInfo(buffer);
		System.out.println("------------------------------------------------");
		//���������з�����
		buffer.put("Hello world!!!".getBytes());//14/100 /100
		getByteBufferInfo(buffer);
		System.out.println("------------------------------------------------");
		//ʹ��flip���������Ϣ:
		buffer.flip();
		getByteBufferInfo(buffer);//0/14/100
		System.out.println("------------------------------------------------");
		//��ȡ����
		byte[] b=new byte[5];
		buffer.get(b);
		System.out.println(new String(b));
		getByteBufferInfo(buffer);//5/14/100
		System.out.println("------------------------------------------------");
		//����clear����
		/*
		 * buffer.clear(); getByteBufferInfo(buffer); //0/100/100 buffer.get(b);
		 * System.out.println(new
		 * String(b));//������clear������������Ȼ����ֻ�ǽ�position����Ϊ0��limit����Ϊ����ֵ
		 * System.out.println("------------------------------------------------");
		 * getByteBufferInfo(buffer);//5/100/100
		 */		
		System.out.println("------------------------------------------------");
		
		buffer.mark();//��Ǵ˿�position��ֵ5,����ǿ��Ի�ȥ��
		byte[] b1=new byte[6];
		buffer.get(b1);
		System.out.println(new String(b1));
		getByteBufferInfo(buffer);//11/14/100
		buffer.reset(); //�ص����λ��
		getByteBufferInfo(buffer);//5/14/100
		System.out.println("------------------------------------------------");
		if(buffer.hasRemaining()) {
			System.out.println(buffer.remaining());//buffer.remaining()����һ��intֵ��������ʣ��������ַ�
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
