package swingdemo1;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JDialogDemo extends JDialog{
     public JDialogDemo(JFrame f) {
    	 super(f,"JDialog Test",true);//该方法设置阻塞功能，将true改为false则没有阻塞功能
    	 Container c= getContentPane( );
    	 c.add(new JLabel("This is a dialog"));
    	 setBounds(200,200,300,200);
    	 setVisible(true);
    	 
     }
     public static void main(String[] args) {
		//JDialogDemo jdd=new JDialogDemo();
		JFrame f=new JFrame("Main Window");
		f.setBounds(50,50,500,400);
		Container c=f.getContentPane();
		JButton jb=new JButton("Show Dialog");
		c.setLayout(new FlowLayout());
		c.add(jb);
		f.setVisible(true);
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);
		jb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new JDialogDemo(f);
			}
			
		});
	}
}
