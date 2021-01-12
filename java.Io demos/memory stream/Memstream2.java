
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

//这是以前版本的写法，现在不是很推荐使用，新版本有InputStream的readAllBytes方法，当文件非常大时同样不推荐使用
public class Memstream2 {
    public static void main(String[] args) throws IOException {
        File file = new File("treeview.txt");
        if (file.exists()) {
            InputStream is = new FileInputStream(file);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();// 这里不能用OutputStream类型接收，因为这是子类特有方法
            byte[] b = new byte[10];
            int len = 0;
            while ((len = is.read(b)) != -1) {
                bos.write(b, 0, len);
            }
            String content = new String(bos.toByteArray());
            System.out.println(content);
        }

    }
}