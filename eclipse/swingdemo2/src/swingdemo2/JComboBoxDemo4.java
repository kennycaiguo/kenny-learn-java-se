package swingdemo2;
/*
 * 这个实例演示了用ComboBoxModel来添加数据
 * 
 * 调用JComboBox的setMedol(ComboBoxModel cbm)
 * */

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class JComboBoxDemo4 extends JFrame{
	       public JComboBoxDemo4() {
	    	   setBounds(100,50,300,200);
	    	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	    	   Container c =getContentPane();
	    	   c.setLayout(null);
	    	   String[] args= {"中国","美国","俄罗斯"};
	    	   JComboBox<String> jc=new JComboBox<>();//JComboBox支持泛型,这个是第二种方法
                ComboBoxModel cbm=new DefaultComboBoxModel<>(args);
                jc.setModel(cbm);
                jc.setEditable(true); //设置JComboBox可以编辑，默认是不可编辑
	    	   jc.setBounds(30,30,120,20);
	    	   c.add(jc);
	    	   JButton b=new JButton("print");
	    	   b.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					 System.out.println("Item idex:"+jc.getSelectedIndex());
					 System.out.println("item text:"+jc.getSelectedItem());
				}
	    		   
	    	   });
	    	   b.setBounds(170,30,80,20);
	    	   c.add(b);
	    	   setVisible(true);
	       }
       public static void main(String[] args) {
		 JComboBoxDemo4 jcd=new JComboBoxDemo4();
}
}
