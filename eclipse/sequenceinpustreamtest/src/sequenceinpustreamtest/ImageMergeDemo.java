package sequenceinpustreamtest;
import java.io.*;

public class ImageMergeDemo {
    public static void main(String[] args) throws IOException {
		File infile1=new File("d:/pic/girls/girl1.jpg");
		File infile2=new File("d:/pic/girls/girl2.jpg");
		File outfile=new File("src/girlmerg.jpg");
		
		FileOutputStream fos =new FileOutputStream(outfile);
		FileInputStream fis1 =new FileInputStream(infile1);
		FileInputStream fis2 =new FileInputStream(infile2);
		
		SequenceInputStream sis =new SequenceInputStream(fis1, fis2);
		byte[] buf=new byte[1024];
		int len=0;
		 while((len=sis.read(buf))!=-1) {
			 fos.write(buf);
		 }
		 sis.close();
		fos.close();
		
		
	}
}
