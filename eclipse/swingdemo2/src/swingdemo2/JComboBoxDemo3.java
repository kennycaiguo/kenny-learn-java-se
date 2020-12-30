package swingdemo2;
/*
 * 这个实例演示了用JComboBox的构造方法来添加数据
 * */

import javax.swing.*;

import java.awt.*;
public class JComboBoxDemo3 extends JFrame{
	       public JComboBoxDemo3() {
	    	   setBounds(100,50,300,200);
	    	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	   Container c =getContentPane();
	    	   c.setLayout(null);
	    	   String[] items= {"girl","women","man"};
	    	   JComboBox<String> jc=new JComboBox<>(items);//JComboBox支持泛型,这个是第二种方法
                
	    	   jc.setBounds(30,30,120,20);
	    	   c.add(jc);
	    	   setVisible(true);
	       }
       public static void main(String[] args) {
		 JComboBoxDemo3 jcd=new JComboBoxDemo3();
}
}
