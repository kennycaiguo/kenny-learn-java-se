import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class OutDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileOutputStream fs = new FileOutputStream(new File("test.txt"), true);// true表示常用追加方式创建文件
        byte[] buf = ",oh i love learning java!!!".getBytes();
        try {
            fs.write(buf);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            fs.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}