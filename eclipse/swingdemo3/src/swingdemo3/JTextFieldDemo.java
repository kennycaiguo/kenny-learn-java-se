package swingdemo3;
/*
   setIconImage(new ImageIcon("pig.png").getImage());设置窗体图标
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JTextFieldDemo extends JFrame {
    public JTextFieldDemo() {
    	 setBounds(50,50,400,300);
    	 // JFrame f =new JFrame();
    	  setTitle("java文本框实例");
    	  setIconImage(new ImageIcon("pig.png").getImage());
  	   setDefaultCloseOperation(EXIT_ON_CLOSE);
  	   Container c= getContentPane();
  	   c.setLayout(null);
  	   JTextField jf=new JTextField();
  	   jf.setBounds(10,10,200,40);
  	  
  	   c.add(jf);
  	 JButton jb=new JButton("get");
	   jb.setBounds(220,20,100,30);
	   jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 System.out.println(jf.getText());
		}
		   
	   });
	   
	   c.add(jb);
	   setVisible(true);
    }
    public static void main(String[] args) {
		new JTextFieldDemo ();
	}
}
