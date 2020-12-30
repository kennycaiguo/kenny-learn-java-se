package swingdemo3;
/*
 * 这个实例演示了文本域的使用
 * 注意：文本域没有addActionListener方法而文本框和密码框则有
 * 文本域可以设置行数和列数
 * 利用setRows(int) 和setColumns(int)方法
 * 可以利用文本域的append(String)方法向文本域追加内容
 * 可以利用文本域的.insert(string , pos)方法向文本域第pos个字符的位置插入内容
   setIconImage(new ImageIcon("pig.png").getImage());设置窗体图标
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class JTextAreaDemo extends JFrame {
    public JTextAreaDemo() {
    	 setBounds(50,50,500,300);
    	 // JFrame f =new JFrame();
    	  setTitle("java文本域实例");
    	  setIconImage(new ImageIcon("pig.png").getImage());
  	   setDefaultCloseOperation(EXIT_ON_CLOSE);
  	   Container c= getContentPane();
  	   c.setLayout(null);
  	   JTextArea ja=new JTextArea();
  	    
  	   //ja.setBounds(10,10,200,100);
  	   ja.setFont(new Font("华文仿宋",Font.BOLD,20));
  	   ja.setForeground(Color.green);
  	 JScrollPane jp=new JScrollPane(ja);
  	 jp.setBounds(10,10,300,200);
  	   c.add(jp);
  	   for(int i=0; i<100; i++) {
  		 ja.append("pussy\n");
  	   }
  	  ja.insert("fuck ", 0);
  	 JButton jb=new JButton("get");
	   jb.setBounds(350,20,100,30);
	   jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 System.out.println(ja.getText());
		}
		   
	   });
	   
	   c.add(jb);
	   setVisible(true);
    }
    public static void main(String[] args) {
		new JTextAreaDemo ();
	}
}
