import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyDir {
    public static void main(String[] args) throws IOException {
        File srcFolder = new File("D:\\mytest");
        File dstFolder = new File("E:\\youtest");
        dstFolder.mkdir();
        copyFolder(srcFolder, dstFolder);
    }

    public static void copyFolder(File srcFile, File dstFile) throws IOException {
        if (srcFile.isDirectory()) {
            File newFolder = new File(dstFile, srcFile.getName());
            newFolder.mkdir();

            File[] fileArray = srcFile.listFiles();
            for (File f : fileArray) {
                copyFolder(f, newFolder);
            }

        } else {
            File newFile = new File(dstFile, srcFile.getName());
            copyFile(srcFile, newFile);
        }

    }

    public static void copyFile(File srcFile, File dstFile) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcFile));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dstFile));

        byte[] bys = new byte[1024];
        int len;
        while ((len = bis.read(bys)) != -1) {
            bos.write(bys, 0, len);
        }
        bis.close();
        bos.close();
    }

}
