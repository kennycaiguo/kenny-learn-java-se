import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class OuputStreamWriterDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("test" + File.separator + "out" + File.separator + "test.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        Writer out = new OutputStreamWriter(new FileOutputStream(file));
        out.write("hello OutputStreamWriter!!!我想试一下这个类");
        out.close();
    }
}