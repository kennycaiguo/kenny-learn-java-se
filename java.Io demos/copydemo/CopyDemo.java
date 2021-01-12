import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("../cameltoe.jpg"));
        FileOutputStream fos = new FileOutputStream(new File("../girl.jpg"));
        byte[] buf = new byte[1024];
        int nread;
        while ((nread = fis.read(buf)) > 0) {
            fos.write(buf);
        }
        fos.close();
        fis.close();
    }
}