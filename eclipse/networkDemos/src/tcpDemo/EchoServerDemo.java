package tcpDemo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class EchoServerDemo {
    private int port=8888;
    private ServerSocket serverSocket;

    /*
    服务器通过一直监听端口，来接受客户程序的连接请求。
    在服务器程序中需要先创建一个ServerSocket对象，在
    构造方法中指定监听的端口。构造方法负责在操作系统中
    把当前进程注册为服务器进程。
     */
    public EchoServerDemo() throws IOException {
        serverSocket=new ServerSocket(port);
        System.out.println("服务器已经启动，，，");
    }

    public static void main(String[] args) throws IOException {
        new EchoServerDemo().service();
    }

    private void service()  {
        while (true){
            Socket socket=null;
            try {
                /*
                服务器程序接下来调用serverSocket对象的accept()方法
                ，该方法一直监听端口，等待客户的连接请求，如果
                接收到一个连接请求，该方法就返回一个Socket对象
                这个Socket对象与客户端的Socket对象形成了一条
                通信线路。
                 */
                socket=serverSocket.accept();
                System.out.println("接受到客户端连接："+socket.getInetAddress());

                /*
                Socket类提供了getInputStream()和getOutputStream()方法，分别返回
                输入流InputStream对象和输出流OutputStream对象。程序只需要向
                输出流写数据，就能向对方发送数据；
                只需要从输入流读数据就能接受来自对方的数据。
                 */

                //Scanner和PrintWriter都是带缓冲的流，能够读入和写出一行数据
                Scanner scanner=new Scanner(socket.getInputStream());
                //参数true表示每写一行，PrintWriter缓存就自动溢出，把数据写到目的地
                PrintWriter printWriter=new PrintWriter(socket.getOutputStream(),true);
                String msg=null;
                while ((msg=scanner.nextLine())!=null){
                    System.out.println("收到："+msg);
                    printWriter.println("echo:"+msg);
                    if (msg.equals("bye")){
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if (socket!=null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
 
