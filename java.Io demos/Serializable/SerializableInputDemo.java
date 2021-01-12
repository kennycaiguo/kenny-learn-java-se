import java.io.FileInputStream;

import java.io.IOException;
import java.io.ObjectInputStream;

public class SerializableInputDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream("book.bk");
        ObjectInputStream ois = new ObjectInputStream(fis);// 需要传入OutputStream对象来实例化
        Book b = (Book) ois.readObject();
        System.out.println(b);
        fis.close();
    }
}