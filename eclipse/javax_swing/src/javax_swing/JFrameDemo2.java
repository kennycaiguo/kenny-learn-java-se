package javax_swing;
/*
  该实例演示了JOptionPane的用法
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameDemo2 {
	public static void main(String[] args) {
		
		JFrame f=new JFrame("First JFrame App");
		FrameTool.CenterFrame(f,600,400);
		Container c=f.getContentPane();
		c.setLayout(new FlowLayout());
		JButton jb1=new JButton("信息框");
		jb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "Hello,Frame!!!","Say Hello",JOptionPane.INFORMATION_MESSAGE);
			}});
		jb1.setBounds(10, 100, 120, 50);
		c.add(jb1);	
		JButton jb2=new JButton("警告框");
		jb2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "Be careful!!!","warning!",JOptionPane.WARNING_MESSAGE);
			}});
		jb2.setBounds(140, 100, 120, 50);
		c.add(jb2);	
		
		JButton jb3=new JButton("错误框");
		jb3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(f, "Error!!!","Error message!",JOptionPane.ERROR_MESSAGE);
			}});
		jb3.setBounds(270, 100, 120, 50);
		c.add(jb3);	
		JButton jb4=new JButton("输入框");
		jb4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputValue = JOptionPane.showInputDialog("Please input a value");
				JOptionPane.showMessageDialog(null, inputValue);
			}});
		jb4.setBounds(410, 100, 120, 50);
		c.add(jb4);	
		JButton jb5=new JButton("有选项的输入框");
		jb5.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				//Object[] possibleValues = { "First", "Second", "Third" };
				Object[] possibleValues = { "Coca", "Pepsi", "Te" };
				Object selectedValue = JOptionPane.showInputDialog(null, 
				"Choose one", "Input",
				JOptionPane.INFORMATION_MESSAGE, null,
				possibleValues, possibleValues[0]);


				JOptionPane.showMessageDialog(null, selectedValue);
			}});
		jb5.setBounds(10, 160, 120, 50);
		c.add(jb5);	
		JButton jb6=new JButton("确认框");
		jb6.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
			int option= JOptionPane.showConfirmDialog(null, "Are you sure to Do this?","Action Confirm!!",JOptionPane.YES_NO_CANCEL_OPTION);
			 String content=null;
			 switch(option) {
				 case 0:
					 content="是";
					 break;
				 case 1:
					 content="否";
					 break;
				 case 2:
					 content="取消";
					 break;
			 }
			JOptionPane.showMessageDialog(null, "You Choosed:"+content);
			}});
		jb6.setBounds(150, 160, 120, 50);
		c.add(jb6);	
		f.setVisible(true);
		
	}
}
