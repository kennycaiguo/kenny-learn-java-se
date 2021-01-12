import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

//PrintWriter类非常好用,可以输出字符串,数字,对象,等等
class Human {
    private String name;
    private int age;
    private String address;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Human() {

    }

    public Human(String name, int age, String address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "Humen:[name:" + this.name + ",age:" + this.age + ",Address:" + this.address + "]";
    }
}

public class PrintWriterDemo {
    public static void main(String[] args) throws IOException {
        try {
            PrintWriter pw = new PrintWriter(new File("pw.txt"));
            pw.write("Created by PrintWriter Class!!!");
            pw.flush(); // PrintWriter是有缓存的,如果没有关闭,必须刷新缓存
            pw.close();
            PrintWriter pw2 = new PrintWriter(new FileOutputStream(new File("pwout.txt")));

            PrintWriter pw3 = new PrintWriter(new FileWriter(new File("pwWriter.txt")));
            /*
             * pw3.write("Created by PrintWriter Class that is constracted by FileWriter!!!"
             * ); pw3.flush(); // PrintWriter是有缓存的,如果没有关闭,必须刷新缓存 pw3.close();
             */
            Human h = new Human("Jack lee", 18, "3 pawsey road kgn5");
            pw3.print(h);
            pw3.close();
            pw2.print("name:");
            pw2.println(h.getName());
            pw2.print("age:");
            pw2.println(h.getAge());
            pw2.print("Address:");
            pw2.println(h.getAddress());
            pw2.flush(); // PrintWriter是有缓存的,如果没有关闭,必须刷新缓存
            pw2.close();
            // 读取文件的内容显示到屏幕上
            InputStream in = new FileInputStream("testdata.txt");
            byte[] data = new byte[1024];
            int read = 0;
            ByteArrayOutputStream bas = new ByteArrayOutputStream();

            while ((read = in.read(data)) != -1) {
                bas.write(data, 0, read);
            }

            // OutputStreamWriter writer = new OutputStreamWriter(bas);
            // PrintWriter pw4 = new PrintWriter(bas);//没有输出
            PrintWriter pw4 = new PrintWriter(System.out);// 需要输出到屏幕必须使用System.out来构建PrintWriter
            // pw4.flush();
            pw4.print(new String(bas.toByteArray()));
            pw4.close();// 当需要将内容输出到屏幕,在调用print方法后必须关闭PrintWriter,否则没有显示
            // System.out.println(new String(bas.toByteArray()));

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        }
    }
}