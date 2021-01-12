import java.io.File;
import java.io.IOException;

//这个程序效率比较低，改进办法是使用静态代码块，参考demo2
public class FiledirDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("Kenny/Filedemo/text.txt");
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (!file.exists()) {
            System.out.println("File not exists ,creat new file.");
            file.createNewFile();
        } else {
            System.out.println("File  exists ,delete file.");
            file.delete();
        }
    }
}