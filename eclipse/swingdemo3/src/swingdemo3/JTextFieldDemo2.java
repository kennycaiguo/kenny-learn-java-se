package swingdemo3;
/*
   setIconImage(new ImageIcon("pig.png").getImage());设置窗体图标
   java中文本框获取输入焦点的方法：jf.requestFocus();
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JTextFieldDemo2 extends JFrame {
    public JTextFieldDemo2() {
    	 setBounds(50,50,400,300);
    	 // JFrame f =new JFrame();
    	  setTitle("java文本框实例");
    	  setIconImage(new ImageIcon("pig.png").getImage());
  	   setDefaultCloseOperation(EXIT_ON_CLOSE);
  	   Container c= getContentPane();
  	   c.setLayout(new FlowLayout());
  	  // JTextField jf=new JTextField(20);
  	 JTextField jf=new JTextField("pussy,pussy!!!");
  	 jf.setColumns(20);
  	 jf.setFont(new Font("华文新魏",Font.BOLD,20));
  	 jf.setForeground(Color.BLUE);//设置文本颜色
  	   //jf.setBounds(10,10,200,40);
  	   c.add(jf);
		
		  JButton jb=new JButton("get");
		  jb.setBounds(220,20,100,30);
		  jb.addActionListener(new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent e) {
		  System.out.println(jf.getText()); 
		  jf.setText("");
		  jf.requestFocus();
		  } });
		  
		  c.add(jb);
		 
	   setVisible(true);
    }
    public static void main(String[] args) {
		new JTextFieldDemo2 ();
	}
}
