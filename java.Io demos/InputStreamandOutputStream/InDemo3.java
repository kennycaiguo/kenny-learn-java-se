import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class InDemo3 {
    public static void main(String[] args) throws IOException {
        FileInputStream fi = new FileInputStream(new File("test.txt"));
        byte buf[] = new byte[1024];// 创建字节数组并且指定长度
        /*
         * int len = 0; while ((len = fi.read(buf)) > 0) { String(buf)); }
         */
        int len = fi.read(buf);
        System.out.print(new String(buf, 0, len));
        fi.close();
    }
}
