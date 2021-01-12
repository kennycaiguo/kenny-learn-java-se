import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.File;

public class BufferedReaderDemo2 {
    public static void main(String[] args) throws IOException {
        /*
         * InputStream in = new FileInputStream(new File("br.txt")); InputStreamReader
         * iReader = new InputStreamReader(in);
         */
        FileReader reader = new FileReader("br.txt");
        BufferedReader br = new BufferedReader(reader);

        String instr = null;
        while ((instr = br.readLine()) != null) {
            System.out.println(instr);
        }
        br.close();
    }
}
