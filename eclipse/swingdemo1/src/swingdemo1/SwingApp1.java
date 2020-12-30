package swingdemo1;

import java.awt.Color;
import java.awt.Container;

import javax.swing.*;

public class SwingApp1 extends JFrame{
	public SwingApp1() {
		 this.setTitle("Swing App1");
		//fr.setBounds(300,300, 500, 400);
		setSize(500,400);
		setLocation(100, 200);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c =getContentPane();
		c.setBackground(Color.LIGHT_GRAY);
		JButton jb=new JButton("An Niu");
	 
		c.add(jb);
		c.invalidate();//验证容器中的组件,建议使用这个
		//fr.setContentPane(c);//让窗体程序载入容器；
		//fr.setResizable(false);//禁用窗体的改变大小功能
		setVisible(true);
	}
  public static void main(String[] args) {
	
	SwingApp1 sw=new SwingApp1( );
	sw.setVisible(true);
}
}
