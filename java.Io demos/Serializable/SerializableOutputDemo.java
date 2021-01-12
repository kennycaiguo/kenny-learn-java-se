import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableOutputDemo {
    public static void main(String[] args) throws IOException {
        Book b = new Book("c和指针", "xxxx", 100);
        FileOutputStream fos = new FileOutputStream("book.bk");
        ObjectOutputStream oos = new ObjectOutputStream(fos);// 需要传入OutputStream对象来实例化
        oos.writeObject(b);
        fos.close();
    }
}