package recursive;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class recursivecopyDemo {
    public static void main(String[] args) throws IOException {
		File olddir =new File("d:/pic");
		File newdir =new File("e:/");
		copyDir(olddir,newdir);
	}
    public static void copyDir(File olddir,File newdir) throws IOException {
    	File dir=new File(newdir.getAbsolutePath(),olddir.getName());
    	//System.out.println(dir.getAbsolutePath());
    	if(!dir.exists()) {
    		dir.mkdir();
    	}
    	File[] files=olddir.listFiles();
    	for(File f :files) {
    		if(f.isFile()) {
    			File file=new File(dir.getAbsolutePath(),f.getName());
    			FileInputStream fis=new FileInputStream(f);
    			FileOutputStream fos=new FileOutputStream(file);
    			byte[] buf=new byte[1024];
    			int len=0;
    			while((len=fis.read(buf))!=-1) {
    				fos.write(buf, 0, len);
    			}
    			fos.close();
    			fis.close();
    			
    		}
    		else if(f.isDirectory()) {
    			copyDir(f,dir);
    		}
    	}
    }
}
