import java.io.File;
import java.io.IOException;

//使用静态代码块，提高程序的效率
public class FiledirDemo2 {
    private static File file = new File("Kenny/Filedemo/text.txt");
    static {
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {

        if (!file.exists()) {
            System.out.println("File not exists ,creat new file.");
            file.createNewFile();
        } else {
            System.out.println("File  exists ,delete file.");
            file.delete();
        }
    }
}