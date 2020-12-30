package cutvids;
 import java.io.*;

 public class CutVideoDemo {
    public static void main(String[] args) throws IOException {
    	File out=new File("e:/vids");
    	//File in=new File("e:/2pussy.avi");
    	File in=new File("e:/playh.wmv");
    	FileInputStream fis=new FileInputStream(in);
    	
    	//byte[] buf=new byte[1024*22000];
    	byte[] buf=new byte[1024*4608];
    	int len=0;
    	for(int i=0;(len=fis.read(buf))!=-1;i++) {
    		//FileOutputStream fos=new FileOutputStream(new File(out,"part"+i +".mp4"));
    		//FileOutputStream fos=new FileOutputStream(new File(out,"part"+i +".avi"));
    		FileOutputStream fos=new FileOutputStream(new File(out,"part"+i +".wmv"));
    		fos.write(buf,0,len);
    		fos.close();
    	}
    	fis.close();
		
	}
}
