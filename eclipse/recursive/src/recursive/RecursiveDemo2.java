package recursive;

import java.io.File;

/*
 利用递归列出一个文件夹下面所有的子孙文件与文件夹
 */
public class RecursiveDemo2 {
   public static void main(String[] args) {
	 recursiveListFile2(new File("d:/pic"), "> ");
 }
   public static void recursiveListFile(File dir,String space) {
	    File[] files =dir.listFiles();
	    for(File file :files) {
	    	if(file.isFile()) {
	    		System.out.println(space+file.getName());
	    	}
	    	else if(file.isDirectory()) {
	    		System.out.println(space+file.getName());
	    		 recursiveListFile(file, " "+space);
	    	}
	    	
	    }
	       
   }
   public static void recursiveListFile2(File dir,String space) {
	   File[] files =dir.listFiles();
	   for(File file :files) {
		   if(file.isFile()) {
			   System.out.println(space+file.getName());
		   }
		   else if(file.isDirectory()) {
			   System.out.println(space+file.getName());
			   recursiveListFile(file, "| "+space);
		   }
		   
	   }
	   
   }
}
