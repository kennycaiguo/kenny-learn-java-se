import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriterDemo {
    public static void main(String[] args) throws IOException {
        FileWriter fr = new FileWriter(new File("writedemo.txt"));
        fr.write("hello ,i am created by a java FileWriter!!!\n");
        fr.append("https://github.com/kennycaiguo/learn-java-se\n");
        fr.close();
    }
}
