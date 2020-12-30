package joinvids;
/*
 合成MP4，可以播放,也可以将多个avi合成成一个MP4
 
 * */
 import java.io.*;
import java.util.Enumeration;
import java.util.Vector;
 
public class JoinVidsDemo {
    public static void main(String[] args) throws IOException {
		
		  File dir =new File("e:/vids"); 
		  File out =new File("e:/fuck.mp4");
		 
//		File dir =new File("e:/fuck");
//		File out =new File("e:/fuckjoined.mp4");
		FileOutputStream fos=new FileOutputStream(out);
		File[] files=dir.listFiles();
		byte[] buf=new byte[1024];
		int len=0;
		Vector<FileInputStream> v=new Vector<FileInputStream>();
		for(File file:files) {
			v.add(new FileInputStream(file));
		}
		Enumeration e=v.elements();
		SequenceInputStream sis =new SequenceInputStream(e);
		while((len=sis.read(buf))!=-1) {
			fos.write(buf,0,len);
		}
		fos.close();
		sis.close();
	}
}
