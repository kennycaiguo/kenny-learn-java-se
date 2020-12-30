package recursive;

import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class MoveFilesDemo {
   public static void main(String[] args) throws IOException {
	    cutDir(new File("d:/c#docs"),new File("e:/"));
	     
 }
 

   public static void cutDir(File source,File target) {
	   File dir=new File(target.getAbsolutePath(),source.getName());
	   //System.out.println(dir.getAbsolutePath());
	   if(!dir.exists()) {
		   dir.mkdir();
	   }
	   File[] files=source.listFiles();
	   for(File f :files) {
		   if(f.isFile()) {
			   f.renameTo(new File(dir,f.getName()));
		   }
		   else if(f.isDirectory()) {
			   cutDir(f,dir);
		   }
		   f.renameTo(dir);
		  f.delete();
	   }
	  source.delete();
	  
   }
   
}
