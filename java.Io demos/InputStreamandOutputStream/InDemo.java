import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InDemo {
    public static void main(String[] args) throws FileNotFoundException {
        FileInputStream fi = new FileInputStream(new File("test.txt"));
        byte buf[] = { 0 };
        try {
            // fi.read(buf);//这个方法之读取一个字符
            buf = fi.readAllBytes(); // 读取所有文件内容
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("File Content:" + new String(buf)); // 一定要将字节数组的内容转换为String，当文件内容很多的时候不用使用次方法
        try {
            fi.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
