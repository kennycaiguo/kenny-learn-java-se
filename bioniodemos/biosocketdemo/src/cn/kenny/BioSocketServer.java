package cn.kenny;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
/**
 * ͬ����������
 * @author Administrator
 *
 */
public class BioSocketServer {
	
      
	public BioSocketServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        //1.����ServerSocket
		ServerSocket ss=new ServerSocket(9000);
		//2.�����ͻ���
		Socket socket = ss.accept();
		//3.��socket�л�ȡ�ֽ�������
		InputStream inputStream = socket.getInputStream();
		//4.���������ַ�������,���ж�ȡ����
		BufferedReader br=new BufferedReader(new InputStreamReader(inputStream));
		//5.��ȡ����
		String msg;
		if ((msg=br.readLine())!=null) {
			System.out.println("Message received:"+msg);
		}
		
	}

}
