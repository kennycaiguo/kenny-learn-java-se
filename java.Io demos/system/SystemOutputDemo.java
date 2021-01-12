import java.io.IOException;
import java.io.OutputStream;

public class SystemOutputDemo {
    public static void main(String[] args) throws IOException {
        OutputStream out = System.out;
        out.write("Hello OutputStream".getBytes());
    }
}