package nio.chat.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

public class NioChatClient {
	    //������ص�����
	    private final String HOST = "127.0.0.1"; // ��������ip
	    private final int PORT = 9999; //�������˿�
	    private Selector selector;
	    private SocketChannel socketChannel;
	    private String username;
	 
	    //������, ��ɳ�ʼ������
	    public NioChatClient() throws IOException {
	 
	        selector = Selector.open();
	        //���ӷ�����
	        socketChannel = socketChannel.open(new InetSocketAddress("127.0.0.1", PORT));
	        //���÷�����
	        socketChannel.configureBlocking(false);
	        //��channel ע�ᵽselector
	        socketChannel.register(selector, SelectionKey.OP_READ);
	        //�õ�username
	        username = socketChannel.getLocalAddress().toString().substring(1);
	        System.out.println(username + " is ok...");
	 
	    }
	 
	    //�������������Ϣ
	    public void sendInfo(String info) {
	        info = username + " ˵��" + info;
	        try {
	            socketChannel.write(ByteBuffer.wrap(info.getBytes()));
	        }catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	 
	    //��ȡ�ӷ������˻ظ�����Ϣ
	    public void readInfo() {
	        try {
	 
	            int readChannels = selector.select();
	            if(readChannels > 0) {//�п����õ�ͨ��
	 
	                Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
	                while (iterator.hasNext()) {
	 
	                    SelectionKey key = iterator.next();
	                    if(key.isReadable()) {
	                        //�õ���ص�ͨ��
	                       SocketChannel sc = (SocketChannel) key.channel();
	                       //�õ�һ��Buffer
	                        ByteBuffer buffer = ByteBuffer.allocate(1024);
	                        //��ȡ
	                        sc.read(buffer);
	                        //�Ѷ����Ļ�����������ת���ַ���
	                        String msg = new String(buffer.array());
	                        System.out.println(msg.trim());
	                    }
	                }
	                iterator.remove(); //ɾ����ǰ��selectionKey, ��ֹ�ظ�����
	            } else {
	                //System.out.println("û�п����õ�ͨ��...");
	 
	            }
	 
	        }catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	 
	    public static void main(String[] args) throws Exception {
	        //�������ǿͻ���
	    	NioChatClient chatClient = new NioChatClient();
	        //����һ���߳�, ÿ��3�룬��ȡ�ӷ�������������
	        new Thread() {
	            public void run() {
	 
	                while (true) {
	                    chatClient.readInfo();
	                    try {
	                        Thread.currentThread().sleep(3000);
	                    }catch (InterruptedException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }.start();
	 
	        //�������ݸ���������
	        Scanner scanner = new Scanner(System.in);
	         
	        while (true) {
	        	System.out.println("������Ϣ��");
	            String s = scanner.nextLine();
	            chatClient.sendInfo(s);
	        }
	    }
}
