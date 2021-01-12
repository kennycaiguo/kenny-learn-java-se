import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

//这个实例充分体现了装饰设计模式
class PrintUtil implements AutoCloseable {// 自己动手实现一个能输出任何类型的打印工具类
    private OutputStream output;

    public PrintUtil(OutputStream output) {
        this.output = output;
    }

    public void print(String s) throws IOException {
        this.output.write(s.getBytes());
    }

    public void println(String s) throws IOException {
        this.print(s + "\n");
    }

    public void print(int num) throws IOException {
        this.print(String.valueOf(num));
    }

    public void println(int num) throws IOException {
        this.println(String.valueOf(num));
    }

    public void print(double num) throws IOException {
        this.print(String.valueOf(num));
    }

    public void println(double num) throws IOException {
        this.println(String.valueOf(num));
    }

    public void print(Object o) throws IOException {
        this.print(o.toString());
    }

    public void println(Object o) throws IOException {
        this.println(o.toString());
    }

    @Override
    public void close() throws Exception {
        // TODO Auto-generated method stub
        this.output.close();
    }
}

public class PrintUtilDemo {
    public static void main(String[] args) throws Exception {
        File file = new File("testdata.txt");
        FileOutputStream fos = new FileOutputStream(file);
        String content = "name:test,price: 1000\nname:test2,price: 2000 \nname:test3,price: 3000 ";
        PrintUtil pu = new PrintUtil(fos);
        pu.print(content);
        pu.close();

    }
}
