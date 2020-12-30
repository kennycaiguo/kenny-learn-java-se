package swingdemo1;
 
/*
 * 这个例子演示的是网格布局，组件的位置是根据定义的行列来布局
 * 这个布局的特点：1.组件会根据窗体大小的改变而改变2.如果添加的组件数比定义的还多
 * 会自动增加列数。
 * */
 
import java.awt.*;
import java.net.URL;

import javax.swing.*;


public class SwingDemo6 extends JFrame {
      public SwingDemo6() {
    	  setBounds(50,50,500,400);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	  Container c =getContentPane();
   	      
    	  c.setLayout(new GridLayout(7,3,5,5));// 设置为网格布局；设置水平和垂直间距均为5像素
//   	       JButton btn1=new JButton("center"),
//   	    		        btn2=new JButton("east"),
//   	    		        btn3=new JButton("west"),
//   	    		        btn4=new JButton("south"),
//   	    		        btn5=new JButton("north")	;
////   	       btn1.setBounds(10,30,80,30);
//   	       btn2.setBounds(110,30,80,30);
    	  for(int i=1;i<=21;i++) {
  	    	   c.add(new JButton("button"+i));
  	       }
  	        
   	    	  
   	        
   	    setVisible(true);
      }
      public static void main(String[] args) {
		SwingDemo6 sd5=new SwingDemo6();
	}
}
