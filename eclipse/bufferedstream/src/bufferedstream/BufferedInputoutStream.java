package bufferedstream;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.BufferOverflowException;

public class BufferedInputoutStream {
	public static void main(String[] args) throws IOException {
		File file=new File("d:/pic/girls/girl3.jpg");
		FileInputStream fis=new FileInputStream(file);
		BufferedInputStream bis=new BufferedInputStream(fis);
		File file2=new File("src/girl1.jpg");
		FileOutputStream fos =new FileOutputStream(file2);//多次写入数据不用加true也可以因为FileOutputStream内部维护了一个指针。
		  //写入数据后，指针会移动。
		BufferedOutputStream bos =new BufferedOutputStream(fos);
		     // byte[] buf=new byte[1024];
		      //byte[] buf2 =new byte[1024];
		      //String content="",content1="";
		      int read=0;
		      while((read=bis.read())!=-1) {
		    	  bos.write(read);//这样比较好，真正做到读多少，写入多少
		    	 // bos.flush();
		      }
		      bos.close();
		      bis.close();//要先开后关
		       
	 }
}
