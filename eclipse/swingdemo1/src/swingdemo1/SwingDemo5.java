package swingdemo1;
 
/*
 * 这个例子演示的是边界布局，组件的位置是固定的不会随着窗体的变化而变化，
 * 但是大小会随着窗体大小的变化而变化
 * 
 * */
 
import java.awt.*;
import java.net.URL;

import javax.swing.*;


public class SwingDemo5 extends JFrame {
      public SwingDemo5() {
    	  setBounds(50,50,500,400);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	  Container c =getContentPane();
   	      
    	  c.setLayout(new BorderLayout());// 设置为边界不局；
   	       JButton btn1=new JButton("center"),
   	    		        btn2=new JButton("east"),
   	    		        btn3=new JButton("west"),
   	    		        btn4=new JButton("south"),
   	    		        btn5=new JButton("north")	;
//   	       btn1.setBounds(10,30,80,30);
//   	       btn2.setBounds(110,30,80,30);
   	       
   	    	   c.add(btn1,BorderLayout.CENTER);
   	    	   c.add(btn2,BorderLayout.EAST);
   	    	   c.add(btn3,BorderLayout.WEST);
   	    	   c.add(btn4,BorderLayout.SOUTH);
   	    	   c.add(btn5,BorderLayout.NORTH);
   	        
   	    setVisible(true);
      }
      public static void main(String[] args) {
		SwingDemo5 sd5=new SwingDemo5();
	}
}
