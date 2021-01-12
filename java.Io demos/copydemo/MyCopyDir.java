import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
//这个是目录复制实例，比网上下载的一些demo好
public class MyCopyDir {
    static void copy(File src, File dst) throws IOException {
        byte[] buf = new byte[1024];
        int read = 0;

        if (src.isDirectory()) {
            if (!dst.exists()) {
                dst.mkdir();
            }
            File[] files = src.listFiles();
            for (File file : files) {
                copy(file, new File(dst, file.getName()));
            }
        } else {
            FileInputStream fis = new FileInputStream(src); // 注意不能使用目录创建InputStream对象
            FileOutputStream fos = new FileOutputStream(dst);
            while ((read = fis.read(buf)) != -1) {
                fos.write(buf, 0, read);
            }
            fos.close();
            fis.close();
        }

    }

    public static void main(String[] args) throws IOException {
        File srcDir = new File("d:/mytest");
        File dstDir = new File("test2");
        copy(srcDir, dstDir);
    }
}
