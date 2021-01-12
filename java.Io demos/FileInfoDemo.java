import java.io.File;
import java.text.SimpleDateFormat;

public class FileInfoDemo {
    // 获取文件相关信息
    public static void main(String[] args) {
        File file = new File("jbk4.jpg");
        if (file.exists()) {
            String path = file.getAbsolutePath();
            String filename = file.getName();
            String filepath = file.getParent();
            long size = file.length();
            long modtime = file.lastModified();// 获取的是时间戳，需要转换
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String strtime = sdf.format(modtime);// 这个方法可以将时间戳转换为字符串格式的时间
            // Date date = new Date(modtime);
            boolean canread = file.canRead();
            boolean canwdrite = file.canWrite();
            boolean canexecute = file.canExecute();
            boolean isdir = file.isDirectory();
            boolean isfile = file.isFile();
            System.out.println("File Absolue Path:" + path);
            System.out.println("File name:" + filename);
            System.out.println("Path name no file:" + filepath);
            System.out.printf("File size bytes:%s,Mb:%5.2f\n", size, (double) size / 1024 / 1204);
            System.out.println("File Last Modified:" + strtime);
            System.out.println("Can read?:" + canread);
            System.out.println("Can write?:" + canwdrite);
            System.out.println("can execute?:" + canexecute);
            System.out.println("Is this directory?:" + isdir);
            System.out.println("Is this file?:" + isfile);
        }

    }
}
