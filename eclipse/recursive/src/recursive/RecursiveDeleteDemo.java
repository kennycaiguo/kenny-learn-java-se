package recursive;

import java.io.File;

public class RecursiveDeleteDemo {
   public static void main(String[] args) {
	recursiveDelete(new File("d:/pic1"));
}
   public static void recursiveDelete(File dir) {
	   File[] files=dir.listFiles();
	   for(File f:files) {
		        if(f.isFile()) {
			         f.delete();
		         }else if(f.isDirectory()) {
		        	                   recursiveDelete(f);
		   }
		       // f.delete();
	   }
	   dir.delete();
   }
   
}
