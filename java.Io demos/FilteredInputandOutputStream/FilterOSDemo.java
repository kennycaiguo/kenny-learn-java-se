import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FilterOSDemo {
    public static void main(String[] args) throws IOException {
        FileOutputStream fos = new FileOutputStream("1.dat");
        long a = 1234567890987654321l;
        DataOutputStream dos = new DataOutputStream(fos);
        dos.writeLong(a);
        dos.close();
    }
}