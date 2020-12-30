package javax_swing;
/*
  该实例演示了JOptionPane的用法
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JFrameDemo1 {
	public static void main(String[] args) {
		
		JFrame f=new JFrame("模拟注册页面");
		FrameTool.CenterFrame(f,600,400);
		JPanel panel =new JPanel();
		f.add(panel);
		JLabel user=new JLabel("用户名:");
		JTextField userField=new JTextField(12);
		
		panel.add(user);
		panel.add(userField);
		
		JLabel pass=new JLabel("密 码:");
		JPasswordField jpf=new JPasswordField(12);
		
		panel.add(pass);
		panel.add(jpf);
		
		JLabel sex=new JLabel("性别:");
		JRadioButton man=new JRadioButton("男",true);
		man.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				 String value=man.getText();
				JOptionPane.showMessageDialog(null, value);
			}});
		JRadioButton woman=new JRadioButton("女");
		ButtonGroup group =new ButtonGroup();
		group.add(man);
		group.add(woman);
		panel.add(man);
		panel.add(woman);
		
		JLabel favor=new JLabel("爱好:");
		JCheckBox cb1=new JCheckBox("篮球",true);
		cb1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 String value=cb1.getText();
					JOptionPane.showMessageDialog(null, value);
			}});
		JCheckBox cb2=new JCheckBox("Java");
		
		JCheckBox cb3=new JCheckBox("Python");
		JCheckBox cb4=new JCheckBox("足球",true);
		
		JCheckBox cb5=new JCheckBox("看电视");
		JCheckBox cb6=new JCheckBox("泡妞");
		JCheckBox cb7=new JCheckBox("泡妞");
		JCheckBox cb8=new JCheckBox("看AV");
		JCheckBox cb9=new JCheckBox("听音乐");
		JCheckBox cb10=new JCheckBox("逛街",true);
		JCheckBox cb11=new JCheckBox("买书",true);
		
		
		panel.add(cb1);
		panel.add(cb2);
		panel.add(cb3);
		panel.add(cb4);
		panel.add(cb5);
		panel.add(cb6);
		panel.add(cb7);
		panel.add(cb8);
		panel.add(cb9);
		panel.add(cb10);
		panel.add(cb11);
		
		JLabel intro=new JLabel("个人简介:");
		JTextArea area =new JTextArea(10,20);
		area.setLineWrap(true);
		panel.add(intro);
		panel.add(area);
		
		f.setVisible(true);
		
		
	}
}
