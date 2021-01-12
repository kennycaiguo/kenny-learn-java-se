import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

class ReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader reader = new FileReader("mydic.txt");
        FileWriter writer = new FileWriter(new File("diccopy.txt"));
        int len;
        char[] buf = new char[1024];
        while ((len = reader.read(buf)) > 0) {
            writer.write(buf);
        }

        reader.close();
        writer.close();
    }
}