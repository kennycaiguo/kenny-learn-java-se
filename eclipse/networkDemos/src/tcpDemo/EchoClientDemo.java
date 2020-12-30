package tcpDemo;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class EchoClientDemo {
    /*
    在EchoClient程序中，为了能与EchoServer通信，需要先建立一个
    Socket对象
     */
    private String host="localhost";//host表示EchoServer进程所在的主机的名字，当取值为localhost时，表示EchoClient和EchoServer进程运行在同一个主机上
    private int port=8888;//参数port表示EchoServer进程监听的端口
    private Socket socket;

    public static void main(String[] args)throws IOException{
        new EchoClientDemo().talk();
    }

    //如果Socket创建成功，就表示客户端和服务器端建立了连接
    public EchoClientDemo() throws IOException {
        socket=new Socket(host,port);
    }

    private void talk(){
        try (//Socket socket=new Socket(host,port);
             PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
             Scanner scanner=new Scanner(socket.getInputStream());
             Scanner localScanner=new Scanner(System.in)) {
            String line=null;
            while (localScanner.hasNextLine()){
                line=localScanner.nextLine();
                printWriter.println(line);
                System.out.println(scanner.nextLine());
                if (line.equals("bye"))
                    break;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
 
