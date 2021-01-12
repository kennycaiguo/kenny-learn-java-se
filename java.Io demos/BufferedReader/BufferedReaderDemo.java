import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class BufferedReaderDemo {
    public static void main(String[] args) {
        InputStream in = System.in;
        InputStreamReader iReader = new InputStreamReader(in);
        BufferedReader br = new BufferedReader(iReader);
        System.out.println("Please enter message:");
        String instr = null;
        try {
            instr = br.readLine();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("you Entered:" + instr);
    }
}
