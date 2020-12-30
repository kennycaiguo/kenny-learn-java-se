package filetest;
import java.io.*;
public class CopyPic {
    public static void main(String[] args) throws IOException {
    	File fin =new File("d:/pic/girls/girl4.jpg");
		FileReader fr=new FileReader(fin);
		File fout=new File("src/girl.jpg");
		FileWriter fw =new FileWriter(fout);
		char[] buf=new char[1024];
		int read=0;
		while((read=fr.read(buf))!=-1) {
			fw.write(new String(buf));
			
			//read=fr.read();
		}
		fr.close();
		fw.close();
	}
}
