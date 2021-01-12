import java.io.File;

public class FileRenameDemo {
    public static void main(String[] args) {
        File file = new File("c:\\jbk.png");
        file.renameTo(new File("cameltoe.jpg"));// 这个方法有移动文件的能力
        System.out.println(file.getName());

    }
}
