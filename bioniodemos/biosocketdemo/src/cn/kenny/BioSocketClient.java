package cn.kenny;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
/**
 * 同步阻塞案例
 * @author Administrator
 *
 */
public class BioSocketClient {

	public BioSocketClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		//1.创建Socket对象
		 Socket s=new Socket("127.0.0.1",9000);
		 //2.从socket对象中获取字节输出流
		 OutputStream outputStream = s.getOutputStream();
		 //3.构建字符缓冲输出流
        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));
        PrintStream ps=new PrintStream(outputStream);
        ps.print("Hello Server!\n");
        ps.flush();
        //ps.close();
	}

}
