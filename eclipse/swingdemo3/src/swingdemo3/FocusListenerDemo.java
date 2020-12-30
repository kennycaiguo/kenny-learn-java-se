package swingdemo3;
/*   这个例子演示了FocusListener类的使用
 * 并且自己定义MyFocusListener类
   setIconImage(new ImageIcon("pig.png").getImage());设置窗体图标
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.*;

public class FocusListenerDemo extends JFrame {
    public FocusListenerDemo() {
    	 setBounds(50,50,400,300);
    	 // JFrame f =new JFrame();
    	  setTitle("java文本框的焦点监听实例");
    	  setIconImage(new ImageIcon("pig.png").getImage());
  	   setDefaultCloseOperation(EXIT_ON_CLOSE);
  	   Container c= getContentPane();
  	   c.setLayout(null);
  	   JTextField jf1=new JTextField();
  	   jf1.setBounds(10,10,200,40);
  	  
  	   c.add(jf1);
  	 JTextField jf2=new JTextField();
	   jf2.setBounds(10,50,200,40);
	  
	   c.add(jf2);
	   JTextField jf3=new JTextField();
  	   jf3.setBounds(10,90,200,40);
  	  
  	   c.add(jf3);
  	   JLabel jl=new JLabel("没有获得输入焦点");
  	   jl.setBounds(20,150,200,40);
  	 jl.requestFocus();
  	   c.add(jl);
  	   class MyFocusListener implements FocusListener{

		@Override
		public void focusGained(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField j =(JTextField)e.getSource();
			//j.setForeground(Color.green);
			j.setBorder(BorderFactory.createLineBorder(Color.green));
			 
		}

		@Override
		public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
			JTextField j =(JTextField)e.getSource();
			j.setBorder(BorderFactory.createLineBorder(Color.gray));
			 
		}
  		   
  	   }
  	  jf1.addFocusListener(new MyFocusListener());
 	 jf2.addFocusListener(new MyFocusListener());
//  	  
	 jf3.addFocusListener(new MyFocusListener());
	 
	 
  	 JButton jb=new JButton("get");
	   jb.setBounds(220,20,100,30);
	   jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			 System.out.println(jf1.getText());
		}
		   
	   });
	   
	   c.add(jb);
	   setVisible(true);
    }
    public static void main(String[] args) {
		new FocusListenerDemo ();
	}
}
