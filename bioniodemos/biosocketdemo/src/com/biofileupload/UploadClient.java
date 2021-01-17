package com.biofileupload;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;

/**
 * �ϴ��������͵��ļ�������������
 * @author Administrator
 *
 */
public class UploadClient {

	public UploadClient() {
		 
	}

	public static void main(String[] args) {
		String filename="e:\\msdia80.dll";
		 String  extension =filename.substring(filename.indexOf("."));
		 System.out.println(extension);
		 try(InputStream is=new FileInputStream(filename);) {
			 //1.�����ڷ��������ӵ�socket����
			Socket socket=new Socket("127.0.0.1",8888);
			//2.���ֽ��������װ�����������,������ʵ�ֶַ����ݷ���
			DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
			//3.�ȷ����ϴ��ļ��ĺ�׺��������
			dos.writeUTF(extension);
			//4.�����ļ�����
			
			byte[] buffer=new byte[1024];
			int len=0;
			while ((len=is.read(buffer))>0) {
				dos.write(buffer,0,len);
			}
			dos.flush();
			socket.shutdownOutput();//֪ͨ�������ļ��ϴ����������û����һ�䣬�������ᷢ���쳣�������ϴ�ʧ��
		} catch (Exception e) {
			 
		}
	}

}
