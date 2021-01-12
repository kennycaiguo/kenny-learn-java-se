import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class CopyUtil {
    private File srcFile;
    private File dstFile;

    /**
     * 
     * @param args,args��һ�����飬������Ԫ�أ�Դ·����Ŀ��·��
     */
    public CopyUtil(String[] args) {
        if (args.length != 2) {
            System.out.println("��ҪԴ·����Ŀ��·������������");
            System.out.println("�÷���java CopyUtil srcPath dstPath");
            System.exit(1);// �������ԣ������ܼ���ִ��
        }
        this.srcFile = new File(args[0]);
        this.dstFile = new File(args[1]);
    }

    public CopyUtil(String src, String dst) {
        this.srcFile = new File(src);
        this.dstFile = new File(dst);
    }

    public long copy() throws IOException { // ���ؿ����ļ���Ҫ��ʱ��
        long start = System.currentTimeMillis();// ��ȡ��ʼʱ��
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(this.srcFile);
            output = new FileOutputStream(this.dstFile);
            byte[] buf = new byte[2048];
            int len = 0;
            while ((len = input.read(buf)) != -1) {
                output.write(buf, 0, len);
            }
        } catch (IOException e) {
            throw e;
        } finally {
            if (input != null) {
                input.close();
            }
            if (output != null) {
                output.close();
            }
        }
        long end = System.currentTimeMillis();
        return end - start;
    }

    public static void main(String[] args) throws IOException {
        new CopyUtil(args).copy();
    }
}
