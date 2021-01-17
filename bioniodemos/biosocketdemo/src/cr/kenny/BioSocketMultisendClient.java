package cr.kenny;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class BioSocketMultisendClient {

	public BioSocketMultisendClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception, IOException {
		// TODO Auto-generated method stub
		//1.创建Socket对象
		 Socket s=new Socket("127.0.0.1",9000);
		 //2.从socket对象中获取字节输出流
		 OutputStream outputStream = s.getOutputStream();
		 //3.构建字符缓冲输出流
       //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));
		 PrintStream ps=new PrintStream(outputStream);
		 Scanner sc=new Scanner(System.in);
		 String msg=null;
		 while (true) {
			 System.out.println("请输入信息：");
			 msg=sc.nextLine();
			ps.println("Client:"+msg);
			ps.flush();
		}
      
       //ps.close();
	}

}
