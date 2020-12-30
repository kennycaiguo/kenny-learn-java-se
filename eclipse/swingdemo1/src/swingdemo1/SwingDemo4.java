package swingdemo1;
/*
 * 这个例子演示的是流式布局
 * 这个布局的特点：1.组件会根据窗体大小的改变而改变2.当窗体的宽度缩小，组件会自动"拐弯"
 * */
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.net.URL;

import javax.swing.*;


public class SwingDemo4 extends JFrame {
      public SwingDemo4() {
    	  setBounds(50,50,500,400);
    	  setDefaultCloseOperation(EXIT_ON_CLOSE);
    	
    	  Container c =getContentPane();
   	      // c.setLayout(new FlowLayout());//默认是居中显示
    	  //c.setLayout(new FlowLayout(FlowLayout.LEFT));//设置为左对齐
    	  //c.setLayout(new FlowLayout(FlowLayout.RIGHT));//设置为右对齐
    	  c.setLayout(new FlowLayout(FlowLayout.RIGHT,20,20));//设置为右对齐,已经组件的间隔
   	       JButton btn1=new JButton("button1"),btn2=new JButton("button2");
//   	       btn1.setBounds(10,30,80,30);
//   	       btn2.setBounds(110,30,80,30);
   	       for(int i=1;i<=6;i++) {
   	    	   c.add(new JButton("button"+i));
   	       }
   	        
   	    setVisible(true);
      }
      public static void main(String[] args) {
		SwingDemo4 sd4=new SwingDemo4();
	}
}
