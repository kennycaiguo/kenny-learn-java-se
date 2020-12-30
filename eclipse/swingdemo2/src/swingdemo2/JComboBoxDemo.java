package swingdemo2;


import javax.swing.*;

import java.awt.*;
public class JComboBoxDemo {
       public static void main(String[] args) {
		JFrame jf=new JFrame();
		jf.setBounds(50,50,600,400);
		Container c=jf.getContentPane();
		JComboBox jb=new JComboBox();
		jb.setSize(200, 100);
		jb.addItem("pussy");
		jb.addItem("vagina");
		jb.addItem("pussy lips");
		c.setLayout(new FlowLayout());
		c.add(jb);
		jf.setVisible(true);
}
}
