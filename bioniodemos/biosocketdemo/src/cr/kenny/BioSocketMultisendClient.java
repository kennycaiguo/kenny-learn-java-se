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
		//1.����Socket����
		 Socket s=new Socket("127.0.0.1",9000);
		 //2.��socket�����л�ȡ�ֽ������
		 OutputStream outputStream = s.getOutputStream();
		 //3.�����ַ����������
       //BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(outputStream));
		 PrintStream ps=new PrintStream(outputStream);
		 Scanner sc=new Scanner(System.in);
		 String msg=null;
		 while (true) {
			 System.out.println("��������Ϣ��");
			 msg=sc.nextLine();
			ps.println("Client:"+msg);
			ps.flush();
		}
      
       //ps.close();
	}

}
