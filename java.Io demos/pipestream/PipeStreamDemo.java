import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

class SendThread implements Runnable {
    private PipedOutputStream output = new PipedOutputStream();

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            // 通过管道发送数据
            this.output.write("welcome to www.kennycai.org".getBytes());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public PipedOutputStream getOutput() {
        return this.output;
    }
}

class RecvThread implements Runnable {
    private PipedInputStream input = new PipedInputStream();

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            // 通过管道读取数据,但是必须连接管道
            byte[] data = new byte[1024];
            int len = this.input.read(data);
            System.out.println("Message Received:" + new String(data, 0, len));
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public PipedInputStream getInput() {
        return this.input;
    }
}

public class PipeStreamDemo {
    public static void main(String[] args) throws IOException {
        SendThread send = new SendThread();// 创建发送线程实例
        RecvThread recv = new RecvThread();// 创建接收线程实例
        send.getOutput().connect(recv.getInput());// 管道连接
        // 启动发送线程
        new Thread(send).start();
        new Thread(recv).start();
    }
}