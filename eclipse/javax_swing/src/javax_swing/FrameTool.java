package javax_swing;
/*
 
创建一个FrameTool类可以设置窗体的大小和使得窗体居中显示，可以供同类使用
 */
import javax.swing.*;
import java.awt.*;

public class FrameTool {
	    public static void main(String[] args) {
			JFrame f=new JFrame("Swingapp1");
			CenterFrame(f,500,300);
		}
      public static void CenterFrame(JFrame fr,int width,int height) {
    	    Toolkit tk=Toolkit.getDefaultToolkit();
    	    Dimension d=tk.getScreenSize();
    	    fr.setBounds(((int)d.getWidth()-width)/2,((int)d.getHeight()-height)/2,width,height);
    	    //fr.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	   // fr.setVisible(true); 
      }
}
