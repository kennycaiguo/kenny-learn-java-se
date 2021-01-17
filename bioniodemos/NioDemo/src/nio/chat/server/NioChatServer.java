package nio.chat.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NioChatServer {
	 //��������
    private Selector selector;
    private ServerSocketChannel ssChannel;
    private static final int PORT = 9999;
    //������
    //��ʼ������
    public NioChatServer() {
        try {
            // 1����ȡͨ��
            ssChannel = ServerSocketChannel.open();
            // 2���л�Ϊ������ģʽ
            ssChannel.configureBlocking(false);
            // 3�������ӵĶ˿�
            ssChannel.bind(new InetSocketAddress(PORT));
            // 4����ȡѡ����Selector
            selector = Selector.open();
            // 5����ͨ����ע�ᵽѡ������ȥ�����ҿ�ʼָ�����������¼�
            ssChannel.register(selector , SelectionKey.OP_ACCEPT);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    //����
    public void listen() {
        System.out.println("�����߳�: " + Thread.currentThread().getName());
        try {
            while (selector.select() > 0){
                System.out.println("��ʼһ���¼�����~~~");
                // 7����ȡѡ�����е�����ע���ͨ�����Ѿ������õ��¼�
                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                // 8����ʼ������Щ׼���õ��¼�
                while (it.hasNext()){
                    // ��ȡ��ǰ����¼�
                    SelectionKey sk = it.next();
                    // 9���ж�����¼�������ʲô
                    if(sk.isAcceptable()){
                        // 10��ֱ�ӻ�ȡ��ǰ����Ŀͻ���ͨ��
                        SocketChannel schannel = ssChannel.accept();
                        // 11 ���л��ɷ�����ģʽ
                        schannel.configureBlocking(false);
                        // 12�������ͻ���ͨ��ע�ᵽѡ����
                        System.out.println(schannel.getRemoteAddress() + " ���� ");
                        schannel.register(selector , SelectionKey.OP_READ);
                        //��ʾ
                    }else if(sk.isReadable()){
                        //����� (ר��д����..)
                        readData(sk);
                    }
 
                    it.remove(); // �������֮����Ҫ�Ƴ���ǰ�¼�
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            //�����쳣����....
 
        }
    }
 
    //��ȡ�ͻ�����Ϣ
    private void readData(SelectionKey key) {
        //ȡ��������channle
        SocketChannel channel = null;
        try {
           //�õ�channel
            channel = (SocketChannel) key.channel();
            //����buffer
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int count = channel.read(buffer);
            //����count��ֵ������
            if(count > 0) {
                //�ѻ�����������ת���ַ���
                String msg = new String(buffer.array());
                //�������Ϣ
                System.out.println("form �ͻ���: " + msg);
                //�������Ŀͻ���ת����Ϣ(ȥ���Լ�), ר��дһ������������
                sendInfoToOtherClients(msg, channel);
            }
        }catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " ������..");
                e.printStackTrace();
                //ȡ��ע��
                key.cancel();
                //�ر�ͨ��
                channel.close();
            }catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
 
    //ת����Ϣ�������ͻ�(ͨ��)
    private void sendInfoToOtherClients(String msg, SocketChannel self ) throws  IOException{
        System.out.println("������ת����Ϣ��...");
        System.out.println("������ת�����ݸ��ͻ����߳�: " + Thread.currentThread().getName());
        //���� ����ע�ᵽselector �ϵ� SocketChannel,���ų� self
        for(SelectionKey key: selector.keys()) {
            //ͨ�� key  ȡ����Ӧ�� SocketChannel
            Channel targetChannel = key.channel();
            //�ų��Լ�
            if(targetChannel instanceof  SocketChannel && targetChannel != self) {
                //ת��
                SocketChannel dest = (SocketChannel)targetChannel;
                //��msg �洢��buffer
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                //��buffer ������д�� ͨ��
                dest.write(buffer);
            }
        }
    }
 
    public static void main(String[] args) {
        //��������������
    	NioChatServer groupChatServer = new NioChatServer ();
        groupChatServer.listen();
    }

}
