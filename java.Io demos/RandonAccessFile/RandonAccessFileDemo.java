import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.file.AccessMode;
import java.util.RandomAccess;

public class RandonAccessFileDemo {
    public static void main(String[] args) throws IOException {
        File f = new File("emps.txt");
        RandomAccessFile raf = new RandomAccessFile(f, "rw");
        if (!f.exists()) {
            f.createNewFile();
        }
        byte[] data = new byte[1024];
        // 写入数据
        // raf.write("mike 1000".getBytes());
        /*
         * raf.skipBytes(10); raf.write("Joe 900".getBytes()); raf.skipBytes(1000);
         * raf.write("Lucy 1900".getBytes());
         */
        raf.seek(100);// 移动文件指针100个字节
        raf.write("Ken 1000".getBytes());
        // 读取数据
        raf.seek(9);
        raf.read(data);
        System.out.println(new String(data));
        raf.close();
    }
}
