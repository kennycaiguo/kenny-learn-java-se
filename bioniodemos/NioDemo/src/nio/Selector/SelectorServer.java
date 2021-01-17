package nio.Selector;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

 

public class SelectorServer {
/**
 * ������ register(Selector sel, int ops) ��ͨ��ע��ѡ����ʱ��ѡ������ͨ���ļ����¼���
    ��Ҫͨ���ڶ������� ops ָ�������Լ������¼����ͣ��� ��ʹ�� SelectionKey ���ĸ����� ��ʾ����

    �� : SelectionKey.OP_READ ��1��
    д : SelectionKey.OP_WRITE ��4��
    ���� : SelectionKey.OP_CONNECT ��8��
    ���� : SelectionKey.OP_ACCEPT ��16��
    ��ע��ʱ��ֹ����һ���¼��������ʹ�á�λ�򡱲��������ӡ�
     �磺 int interestSet = SelectionKey.OP_READ|SelectionKey.OP_WRITE 

 * @throws Exception
 */
	public static void doServer() throws Exception{
		//1. ��ȡͨ��
		ServerSocketChannel ssChannel = ServerSocketChannel.open();
		//2. �л�������ģʽ
		ssChannel.configureBlocking(false);
		//3. ������
		ssChannel.bind(new InetSocketAddress(9898));
		//4. ��ȡѡ����
		Selector selector = Selector.open();
		//5. ��ͨ��ע�ᵽѡ������, ����ָ�������������¼���
		ssChannel.register(selector, SelectionKey.OP_ACCEPT); //��ѡ���Ͳο�����ע��
		//��ѯʽ�Ļ�ȡѡ�������Ѿ���׼�����������¼�
		 while (selector.select() > 0) {
		        System.out.println("��һ��");
		        //6. ��ȡ��ǰѡ����������ע��ġ�ѡ���(�Ѿ����ļ����¼�)��
		        Iterator<SelectionKey> it = selector.selectedKeys().iterator();
		        while (it.hasNext()) {
		            //7. ��ȡ׼���������������¼�
		            SelectionKey sk = it.next();
		            //8. �жϾ�����ʲô�¼�׼������
		            if (sk.isAcceptable()) {
		                //9. �������վ���������ȡ�ͻ�������
		                SocketChannel sChannel = ssChannel.accept();
		                //10. �л�������ģʽ
		                sChannel.configureBlocking(false);
		                //11. ����ͨ��ע�ᵽѡ������
		                sChannel.register(selector, SelectionKey.OP_READ);
		            } else if (sk.isReadable()) {
		                //12. ��ȡ��ǰѡ�����ϡ���������״̬��ͨ��
		                SocketChannel sChannel = (SocketChannel) sk.channel();
		                //13. ��ȡ����
		                ByteBuffer buf = ByteBuffer.allocate(1024);
		                int len = 0;
		                while ((len = sChannel.read(buf)) > 0) {
		                    buf.flip();
		                    System.out.println(new String(buf.array(), 0, len));
		                    buf.clear();
		                }
		            }
		            //14. ȡ��ѡ��� SelectionKey
		            it.remove();
		        }
		    }
	}
	public SelectorServer() throws Exception {
		// TODO Auto-generated constructor stub
	
		}

	

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
        doServer();
	}

}
