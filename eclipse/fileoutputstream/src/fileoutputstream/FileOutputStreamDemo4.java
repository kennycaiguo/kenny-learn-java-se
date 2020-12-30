package fileoutputstream;
/*
 * 这个例子演示了拷贝图片
 * 
 * */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamDemo4 {
   public static void main(String[] args) throws IOException {
	File file=new File("d:/pic/girls/girl1.jpg");
	FileInputStream fis=new FileInputStream(file);
	File file3=new File("d:/pic/girls/girl2.jpg");
	FileInputStream fis2=new FileInputStream(file3);
	File file2=new File("e:/girl1.jpg");
	FileOutputStream fos =new FileOutputStream(file2,true);//多次写入数据不用加true也可以因为FileOutputStream内部维护了一个指针。
	  //写入数据后，指针会移动。   
	      byte[] buf=new byte[1024];
	      //byte[] buf2 =new byte[1024];
	      //String content="",content1="";
	      int read=0;
	      while((read=fis.read(buf))!=-1) {
	    	  //fos.write(buf,0,read);//这样比较好，真正做到读多少，写入多少
	    	  fos.write(buf,0,read);
	    	  //fos.flush();
	      }
	      while((read=fis2.read(buf))!=-1) {
	    	  //fos.write(buf,0,read);//这样比较好，真正做到读多少，写入多少
	    	  fos.write(buf);
	    	  //fos.flush();
	      }
	      
	      fos.close();
	      fis.close();//要先开后关
	       
 }
}
