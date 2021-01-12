import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.io.Reader;

public class InputStreamReaderDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test" + File.separator + "out" + File.separator + "test.txt");
        if (file.getParentFile().exists()) {
            Reader in = new InputStreamReader(new FileInputStream(file));
            char[] buf = new char[1024];
            in.read(buf);
            System.out.println("content read:" + new String(buf));
            in.close();
        }

    }
}