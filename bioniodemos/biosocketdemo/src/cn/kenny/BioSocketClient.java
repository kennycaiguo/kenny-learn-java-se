package cn.kenny;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.net.Socket;
/**
 * ͬ����������
 * @author Administrator
 *
 */
public class BioSocketClient {

	public BioSocketClient() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		//1.����Socket����
		 Socket s=new Socket("127.0.0.1",9000);
		 //2.��socket�����л�ȡ�ֽ������
		 OutputStream outputStream = s.getOutputStream();
		 //3.�����ַ����������
        //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));
        PrintStream ps=new PrintStream(outputStream);
        ps.print("Hello Server!\n");
        ps.flush();
        //ps.close();
	}

}
