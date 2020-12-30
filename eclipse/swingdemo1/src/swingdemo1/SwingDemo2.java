package swingdemo1;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.net.URL;

import javax.swing.*;


public class SwingDemo2 extends JFrame {
      public SwingDemo2() {
    	  setBounds(50,50,200,300);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    	  setVisible(true);
    	  Container c =getContentPane();
   	  JLabel l=new JLabel("Hello label");
//    	  l.setFont(new Font("华文行楷",Font.BOLD,16));
//    	  l.setForeground(Color.cyan);
//    	  c.add(l);
    	//  URL url =SwingDemo2.class.getResource("girls2.png");
    	  Icon icon=new ImageIcon("src/flchart.png");
    	  l.setIcon(icon);
    	  c.add(l);
      }
      public static void main(String[] args) {
		SwingDemo2 sd2=new SwingDemo2();
	}
}
