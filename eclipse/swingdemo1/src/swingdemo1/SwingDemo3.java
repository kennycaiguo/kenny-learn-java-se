package swingdemo1;
/*
 * 这个例子演示的是绝对布局，组件的位置是固定的不会随着窗体的变化而变化
 * 
 * */
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.net.URL;

import javax.swing.*;


public class SwingDemo3 extends JFrame {
      public SwingDemo3() {
    	  setBounds(50,50,500,400);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	  Container c =getContentPane();
   	       c.setLayout(null);
   	       JButton btn1=new JButton("button1"),btn2=new JButton("button2");
   	       btn1.setBounds(10,30,80,30);
   	       btn2.setBounds(110,30,80,30);
   	       c.add(btn1);
   	       c.add(btn2);
   	    setVisible(true);
      }
      public static void main(String[] args) {
		SwingDemo3 sd3=new SwingDemo3();
	}
}
