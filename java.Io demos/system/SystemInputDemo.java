import java.io.IOException;
import java.io.InputStream;

public class SystemInputDemo {
    public static void main(String[] args) {
        InputStream keyinput = System.in;
        byte[] buf = new byte[100];
        System.out.println("请输入信息：");
        try {
            keyinput.read(buf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("你输入的是:" + new String(buf));
    }
}
