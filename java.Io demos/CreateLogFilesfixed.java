import java.io.File;
import java.io.IOException;

//这个方法比老师的方法要好，老师的方法只有在文件很多的情况下有用，这个版本没有这个问题
class DirRenameUtil2 {

    private File dir; // 操作目录的地址
    private int maxLen = 3;

    public DirRenameUtil2(File dir) {
        this.dir = dir;

        getMaxSeqLength(dir);
        System.out.println(this.maxLen);

    }

    private void getMaxSeqLength(File dir) {
        if (dir.isDirectory()) {
            File f[] = dir.listFiles();
            for (File file : f) {
                getMaxSeqLength(file);
            }
        } else {
            if (dir.isFile()) {
                String filename = dir.getName();
                int endIndex = filename.indexOf(".log");
                String seq = filename.substring(filename.lastIndexOf("-") + 1, endIndex);
                if (maxLen < seq.length()) {
                    maxLen = seq.length();
                }
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
                // String filename = file.getName();
                String filename = file.getAbsolutePath();
                int lastIndex = filename.lastIndexOf("-");
                int endIndex = filename.indexOf(".log");
                String seq = filename.substring(lastIndex + 1, endIndex);
                // String newFile = filename.substring(0, lastIndex + 1) +
                // filename.substring(lastIndex, endIndex);

                if (seq.length() != this.maxLen) {
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
        while (buf.length() != this.maxLen) {
            buf.insert(0, "0");
        }
        // System.out.println(buf.toString());
        return buf.toString();
    }
}

public class CreateLogFilesfixed {

    public static void main(String[] args) throws IOException {
        File dir = new File("d:\\kenny\\logs");
        // System.out.println(dir);
        new DirRenameUtil2(dir).rename();

    }
}
