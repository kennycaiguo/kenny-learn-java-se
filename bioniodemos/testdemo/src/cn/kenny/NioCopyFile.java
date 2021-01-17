package cn.kenny;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class NioCopyFile {

	public NioCopyFile() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
        doCopy("treeview.txt","tv.txt");
	}
    public static void doCopy(String fromPath,String toPath) throws Exception{
		/*
		 * FileInputStream fis=new FileInputStream(fromPath); FileChannel
		 * chan=fis.getChannel(); FileOutputStream fos=new FileOutputStream(toPath);
		 */
    	//创建输入通道
    	File fromFile=new File(fromPath);
    	Path srcPath = fromFile.toPath();
    	FileChannel inputChan=FileChannel.open(srcPath,StandardOpenOption.READ);
    	//创建输出通道
    	File toFile=new File(toPath);
    	Path dstPath = toFile.toPath();
    	FileChannel outputChan=FileChannel.open(dstPath,StandardOpenOption.WRITE,StandardOpenOption.CREATE);
    	int len=0;
    	ByteBuffer buffer=ByteBuffer.allocate(1024);
    	while ((len=inputChan.read(buffer))!=-1) {
    		buffer.flip();//一定需要这个
			outputChan.write(buffer);
			buffer.clear();
		}
    	inputChan.close();
    	outputChan.close();
    }
}
