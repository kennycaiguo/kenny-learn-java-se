import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerDemo2 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new FileInputStream("sc.txt"));
        String str;

        /*
         * while ((str = sc.nextLine()) != null) { System.out.println(str); } //这样子不好
         */
        while (sc.hasNextLine()) {
            str = sc.nextLine();
            System.out.println(str);
        }
    }
}