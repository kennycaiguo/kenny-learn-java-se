package javax_swing;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class SearchFile {
	JFrame f =new JFrame("文件搜索器");
	
	JPanel jp=new JPanel();
	
	JTextField jtf=new JTextField("请输入目录...", 15);
	JButton jb=new JButton("搜索");
	
	JTextArea jta=new JTextArea(15, 15);
	JScrollPane jsp=new JScrollPane(jta);
	
	
	public void init() {
//		        jtf.addActionListener(new ActionListener() {
//
//					@Override
//					public void actionPerformed(ActionEvent e) {
//						 JTextField field =(JTextField)e.getSource();
//						 if(field.getText().equals("请输入目录...")) {
//							 
//							 field.setText("");
//						 }
//					}});
		          jtf.addMouseListener(new MouseAdapter() {
		        	  @Override
		        	public void mouseClicked(MouseEvent e) {
		        		  JTextField field =(JTextField)e.getSource();
							 if(field.getText().equals("请输入目录...")) {
								 
								 field.setText("");
							 }
		        	}
				});
		          jb.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						 String path=jtf.getText();
						 File dir=new File(path);
						 File[] files=dir.listFiles();
						 for(File f:files) {
							 jta.append(f.getAbsolutePath()+"\r\n");
						 }
					}});
				jp.add(jtf);
				jp.add(jb);
				f.add(jp,BorderLayout.NORTH);
				
				f.add(jsp);	
		FrameTool.CenterFrame(f, 400, 500);
		f.setVisible(true);
		}
     public static void main(String[] args) {
		new SearchFile().init();
  }
}
