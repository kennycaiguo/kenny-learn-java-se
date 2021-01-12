import java.io.File;
import java.io.IOException;

//使用静态代码块，提高程序的效率
public class FiledirDemo3 {
    private static File parent = new File("Kenny/Filedemo");
    static {
        if (!parent.getParentFile().exists()) {
            parent.getParentFile().mkdirs();
        }
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 50; i++) {
            new Thread(() -> {
                File file = new File(parent + File.separator + Thread.currentThread().getName());
                if (!file.exists()) {
                    System.out.println("File not exists ,creat new file.");
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                } else {
                    System.out.println("File  exists ,delete file.");
                    file.delete();
                }
            }, "Proc" + i + 1).start();
        }

    }
}