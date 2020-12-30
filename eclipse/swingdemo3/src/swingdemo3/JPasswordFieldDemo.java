package swingdemo3;
/*
 * 这个实例演示了密码框的使用
   setIconImage(new ImageIcon("pig.png").getImage());设置窗体图标
   java中文本框获取输入焦点的方法：jf.requestFocus();
   
   可以为密码框增加监听功能
   利用密码框.getPassword()函数获取密码框输入的内容
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JPasswordFieldDemo extends JFrame {
    public JPasswordFieldDemo() {
    	 setBounds(50,50,400,300);
    	 // JFrame f =new JFrame();
    	  setTitle("java密码框实例");
    	  setIconImage(new ImageIcon("pig.png").getImage());
  	   setDefaultCloseOperation(EXIT_ON_CLOSE);
  	   Container c= getContentPane();
  	   c.setLayout(new FlowLayout());
  	   JPasswordField  jpf = new JPasswordField();
  	   jpf.setColumns(20);
  	   jpf.setFont(new Font("华文新魏",Font.BOLD,20));
  	  // jpf.setEchoChar('*');
  	  jpf.setEchoChar('\u2605');
		c.add(jpf);
//		  JButton jb=new JButton("get");
//		  jb.setBounds(220,20,100,30);
		  jpf.addActionListener(new ActionListener() {
		  
		  @Override public void actionPerformed(ActionEvent e) {
		  System.out.println(jpf.getPassword()); 
		  jpf.setText("");
		  jpf.requestFocus();
		  } });
		  
		   
	   setVisible(true);
    }
    public static void main(String[] args) {
		new JPasswordFieldDemo ();
	}
}
