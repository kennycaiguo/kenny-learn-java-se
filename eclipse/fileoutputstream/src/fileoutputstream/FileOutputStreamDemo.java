package fileoutputstream;
/*
 * 这个例子演示了FileOutputStream的覆盖方式写入数据，还有一种构造方法可以
 * 用Append方式写入数据的请见Demo2
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo {
   public static void main(String[] args) throws IOException {
	File file=new File("src/test.txt");
	FileOutputStream fos =new FileOutputStream(file);
	      String str="hello ,girls!!! hello ,pussies!!! hello ,vaginas";
	      byte[] buf=str.getBytes();
	      fos.write(buf);
	      fos.close();
 }
}
