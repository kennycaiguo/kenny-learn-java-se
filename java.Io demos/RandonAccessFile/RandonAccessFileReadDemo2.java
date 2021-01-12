import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandonAccessFileReadDemo2 {
    public static final int MAX_LEN = 11;

    // 其实这就是数据库软件的实现原理
    public static void main(String[] args) throws IOException {
        File file = new File("e:\\randomfiles\\students.data");
        RandomAccessFile raf = new RandomAccessFile(file, "r");
        byte[] buf = new byte[11];
        if (file.exists()) {
            raf.skipBytes(30);
            int age = 0;
            raf.read(buf);
            age = raf.readInt();
            System.out.printf("name:%s,age :%d\n", new String(buf).trim(), age);
            raf.read(buf);
            age = raf.readInt();
            System.out.printf("name:%s,age :%d\n", new String(buf).trim(), age);
            raf.seek(0);
            raf.read(buf);
            age = raf.readInt();
            System.out.printf("name:%s,age :%d\n", new String(buf).trim(), age);
        }

        /*
         * String[] names = new String[] { "Mike lee", "Mary", "July", "Brandy",
         * "zhangsansan" }; int[] ages = new int[] { 17, 18, 19, 20, 18 }; for (int i =
         * 0; i < names.length; i++) { String name = addSpace(names[i]);
         * raf.write(names[i].getBytes()); raf.writeInt(ages[i]); }
         */
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
