import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandonAccessFileWriteDemo2 {
    public static final int MAX_LEN = 11;

    public static void main(String[] args) throws IOException {
        File file = new File("e:\\randomfiles\\students.data");

        if (!file.getParentFile().exists()) { // 如果是使非当前目录的话,需要这些代码
            file.getParentFile().mkdirs();
        }

        RandomAccessFile raf = new RandomAccessFile(file, "rw");
        String[] names = new String[] { "zhangsansan", "Mike lee", "Mary", "July", "Brandy" };
        int[] ages = new int[] { 17, 18, 19, 20, 18 };
        for (int i = 0; i < names.length; i++) {
            String name = addSpace(names[i]);
            raf.write(name.getBytes());
            raf.writeInt(ages[i]);
        }
        raf.close();
    }

    public static String addSpace(String val) {
        StringBuffer buf = new StringBuffer(val);
        while (buf.length() < MAX_LEN) {
            buf.append(" ");
        }
        return buf.toString();
    }
}
