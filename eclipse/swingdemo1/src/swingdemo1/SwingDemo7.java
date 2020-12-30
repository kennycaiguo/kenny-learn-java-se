package swingdemo1;
 
/*
 * 这个例子演示的是网格组布局
 * */
 
import java.awt.*;
import java.net.URL;

import javax.swing.*;


public class SwingDemo7 {
      JFrame f=new JFrame();
      Container c;
      void createFrame() {
    	 c= f.getContentPane();
    	 c.setLayout(new GridBagLayout());
    	  f.setSize(800, 600);
    	  f.setLocationRelativeTo(null);
    	  f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  
      }
      void init() {
    	  GridBagConstraints g1=new GridBagConstraints();
    	  g1.gridx =0;
    	  g1.gridy =0;
    	  JButton btn1=new JButton("button1"),
    			       btn2=new JButton("button2"),
    				   btn3=new JButton("button3");
    	  c.add(btn1,g1);
    	  GridBagConstraints g2=new GridBagConstraints();
    	  g2.gridx =1;
    	  g2.gridy =1;
    	  c.add(btn2,g2);
    	  GridBagConstraints g3=new GridBagConstraints();
    	  g3.gridx =2;
    	  g3.gridy =2;
    	  g3.gridwidth=1;
    	  g3.gridheight=5;
    	  c.add(btn3,g3);
    	  
      }
      
      void init2() {
    	
    	  GridBagConstraints g1=new GridBagConstraints();
    	  g1.gridx =0;
    	  g1.gridy =1;
    	  g1.gridwidth =2;
    	  g1.gridheight=1;
    	  g1.anchor=GridBagConstraints.EAST;
    	  g1.fill=GridBagConstraints.HORIZONTAL;
    	  JPanel jp= new JPanel();
    	  jp.setBackground(Color.green);
    	 
    	  /*JButton btn1=new JButton("button1"),
			       btn2=new JButton("button2"),
				   btn3=new JButton("button3");*/
    	  c.add(new JButton("button1"),g1);
    	  g1.anchor=GridBagConstraints.EAST;
    	  g1.fill=GridBagConstraints.HORIZONTAL;
    	  c.add(jp,g1);
    	  GridBagConstraints g2=new GridBagConstraints();
    	  g2.gridx =3;
    	  g2.gridy =2;
    	  g2.ipadx=10;
    	  g2.ipady=10;
    	  g2.fill=GridBagConstraints.HORIZONTAL;
    	  c.add(new JButton("button2"),g2);
    	  
    	  GridBagConstraints g3=new GridBagConstraints();
    	  g3.gridx =6;
    	  g3.gridy =3;
    	  g3.weightx=5;
     	 g3.weighty=5;
    	  
    	 g3.fill=GridBagConstraints.VERTICAL;
    	  c.add(new JButton("button3"),g3);
    	  
    	  GridBagConstraints g4=new GridBagConstraints();
    	  g4.gridx =7;
    	  g4.gridy =4;
    	 g4.weightx=5;
    	 g4.weighty=5;
    	  
    	 g4.fill=GridBagConstraints.BOTH;
    	  c.add(new JButton("button4"),g4);
      }
      public static void main(String[] args) {
		SwingDemo7 sd7=new SwingDemo7();
		sd7.createFrame();
		sd7.init2();
		sd7.f.setVisible(true);
		
	}
}
