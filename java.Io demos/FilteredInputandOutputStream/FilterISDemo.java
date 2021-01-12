import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FilterISDemo {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("1.dat");
        DataInputStream dis = new DataInputStream(fis);
        long data = dis.readLong();
        System.out.println("data=" + data);
        dis.close();
    }
}
