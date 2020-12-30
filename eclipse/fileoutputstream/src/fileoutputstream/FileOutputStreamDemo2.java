package fileoutputstream;
/*
 * 这个例子演示了FileOutputStream的用Append方式写入数据
 * 
 * 
 * */
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo2 {
   public static void main(String[] args) throws IOException {
	File file=new File("src/test.txt");
	FileOutputStream fos =new FileOutputStream(file,true);
	      String str="hello ,girls!!! hello ,pussies!!! hello ,vaginas\n";
	      byte[] buf=str.getBytes();
	      fos.write(buf);
	      fos.close();
 }
}
