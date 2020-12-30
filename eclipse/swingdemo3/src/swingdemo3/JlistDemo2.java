package swingdemo3;
/*这是更灵活的JList添加元素的方法！！！
 *  JScrollPanes是滚动条面板，要放到Container中
 *  具体做法，先利用  JScrollPane jp=new JScrollPane(jl);
 *  创建一个滚动条面板对象，jl是JList对象
 *  然后 jp.setBounds(10,10,100,100); 再c.add(jp);
 * 
 * */
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class JlistDemo2 extends JFrame{
   public JlistDemo2() {
	   setBounds(50,50,400,300);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   Container c= getContentPane();
	   c.setLayout(null);
	  
	   
	   DefaultListModel<String> model=new DefaultListModel<> ();
	    
		   model.addElement("mouth");
		   model.addElement("breast");
		   model.addElement("hip");
		   model.addElement("nevol");
		   model.addElement("clitoris");
		   model.addElement("outerlips");
		   model.addElement("innerlips");
		   model.addElement("pussy");
		   model.addElement("vagina");
	  
	  
	   JList<String> jl=new JList<>();
	   jl.setModel(model);    
	   model.removeElement("mouth");
	   jl.setModel(model);  
	  // jl.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);//设置为单选
	   jl.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);//只能连续多选相邻的元素
	   //jl.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);//任意方式多选
	   JScrollPane jp=new JScrollPane(jl);
	   jp.setBounds(10,10,100,100);
	   c.add(jp);
	   JButton jb=new JButton("get");
	   jb.setBounds(120,90,100,30);
	   jb.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			 
			java.util.List <String> list=jl.getSelectedValuesList();
			for(String value : list) {
				System.out.println(value);
			}
		}
		   
	   });
	   c.add(jb);
	   setVisible(true);
   }
   public static void main(String[] args) {
	new JlistDemo2();
	
}
}
