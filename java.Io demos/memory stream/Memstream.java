import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Memstream {
    public static void main(String[] args) throws IOException {
        String msg = "welcome to KENNY.com";
        InputStream is = new ByteArrayInputStream(msg.getBytes());
        OutputStream os = new ByteArrayOutputStream();
        int data = 0;
        while ((data = is.read()) != -1) {
            os.write(Character.toLowerCase(data));// 输出后只是在内存中，需要使用System.out.println函数输出到屏幕
        }
        System.out.println(os);// welcome to kenny.com
        is.close();
        os.close();
    }
}