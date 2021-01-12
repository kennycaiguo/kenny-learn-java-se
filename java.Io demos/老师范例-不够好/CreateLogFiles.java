import java.io.File;
import java.io.IOException;

class DirRenameUtil {
    /*
     * //private static File dir = new File("d:" + File.separator + "kenny" +
     * File.separator + "logs" + File.separator); static { if (!dir.exists()) {
     * dir.mkdirs(); } }
     */
    private File dir; // 操作目录的地址
    private int sequenceLenth;// 文件编号的最大长度
    private int fileCount;

    public DirRenameUtil(File dir) {
        this.dir = dir;
        this.calFileCount(dir);
        System.out.println(this.fileCount);
        this.sequenceLenth = String.valueOf(this.fileCount).length();
        //System.out.println(this.sequenceLenth);

    }

    private void calFileCount(File file) {
        if (file.isDirectory()) {
            File list[] = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    this.calFileCount(f);
                }
            }
        } else {
            if (file.isFile()) {
                this.fileCount++;
            }
        }

    }

    public void rename() {
        this.renameHandle(this.dir);
    }

    private void renameHandle(File file) {
        if (file.isDirectory()) {
            File list[] = file.listFiles();
            if (list != null) {
                for (File f : list) {
                    this.renameHandle(f);
                }
            }
        } else {
            if (file.isFile()) {
                String filename = file.getName();
                int lastIndex = filename.lastIndexOf("-");
                int endIndex = filename.indexOf(".log");
                String seq = filename.substring(lastIndex + 1, endIndex);
                // String newFile = filename.substring(0, lastIndex + 1) +
                // filename.substring(lastIndex, endIndex);

                if (seq.length() != this.sequenceLenth) {
                    String newFile = filename.substring(0, lastIndex + 1) + this.AddZero(seq) + ".log";
                    System.out.println(newFile);
                    file.renameTo(new File(newFile));
                }
            }
        }

    }

    public String AddZero(String val) {
        System.out.println(val);
        StringBuffer buf = new StringBuffer(val);
        while (buf.length() !=this.sequenceLenth) {
            buf.insert(0, "0");
        }
       // System.out.println(buf.toString());
        return buf.toString();
    }
}

public class CreateLogFiles {

    public static void main(String[] args) throws IOException {
        File dir = new File("d:\\kenny\\logs");
        System.out.println(dir);
        new DirRenameUtil(dir).rename();

    }
}
