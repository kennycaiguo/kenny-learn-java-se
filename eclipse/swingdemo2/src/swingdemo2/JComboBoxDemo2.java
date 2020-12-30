package swingdemo2;


import javax.swing.*;

import java.awt.*;
public class JComboBoxDemo2 extends JFrame{
	       public JComboBoxDemo2() {
	    	   setBounds(100,50,300,200);
	    	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	   Container c =getContentPane();
	    	   c.setLayout(null);
	    	   JComboBox<String> jc=new JComboBox<>();//JComboBox支持泛型
	    	   jc.addItem("身份证");
	    	   jc.addItem("学生证");
	    	   jc.addItem("工作证");
	    	   jc.setBounds(30,30,120,20);
	    	   c.add(jc);
	    	   setVisible(true);
	       }
       public static void main(String[] args) {
		 JComboBoxDemo2 jcd=new JComboBoxDemo2();
}
}
