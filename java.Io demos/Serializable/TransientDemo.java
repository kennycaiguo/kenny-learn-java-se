import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Shu implements Serializable {
    private String title;
    private transient String author; // 加了transient这个关键字后，这个属性就不会序列化
    private double price;

    public Shu() {
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Shu(String title, String author, double price) {
        this.setTitle(title);
        this.setAuthor(author);
        this.setPrice(price);
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Shu[title:" + this.title + ",author:" + this.author + ",price:" + this.price + "]";
    }
}

public class TransientDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Shu s = new Shu("Java网络编程", "kenny", 99.5);
        // ser(s);
        // 反序列化
        Shu s1 = (Shu) deser();
        System.out.println(s1);
    }

    public static void ser(Object o) {
        ObjectOutputStream output;
        try {
            output = new ObjectOutputStream(new FileOutputStream("shu.ser"));
            output.writeObject(o);
            output.close();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public static Object deser() throws FileNotFoundException, IOException, ClassNotFoundException {
        ObjectInputStream input = new ObjectInputStream(new FileInputStream("shu.ser"));
        Object o = input.readObject();
        return o;

    }
}
