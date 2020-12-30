package fileinputstreamtest;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamDemo {
      public static void main(String[] args) throws IOException {
		File file =new File("src/shttp.txt");
        FileInputStream fis =new FileInputStream(file);
       byte[] b=new byte[1024];
        int read=0;
        String content="";
        while((read=fis.read(b))!=-1) {
        	content+=new String(b);
        	
        }
        System.out.println(content);
        fis.close();
  }
}
