package swingdemo3;
/*
 *  JScrollPanes是滚动条面板，要放到Container中
 *  具体做法，先利用  JScrollPane jp=new JScrollPane(jl);
 *  创建一个滚动条面板对象，jl是JList对象
 *  然后 jp.setBounds(10,10,100,100); 再c.add(jp);
 * 
 * */
import java.awt.*;
import javax.swing.*;
public class JlistDemo extends JFrame{
   public JlistDemo() {
	   setBounds(50,50,400,300);
	   setDefaultCloseOperation(EXIT_ON_CLOSE);
	   Container c= getContentPane();
	   c.setLayout(null);
	  
	   String[] items= {"pussy","vagina","outer lips","inner lips","clitoris","breast","lips","ass"};
	   //JList<String> jl=new JList<>(items);//方法一；
	   DefaultListModel<String> model=new DefaultListModel<> ();
	   for(String tmp : items) {
		   model.addElement(tmp);
	   }
	   //JList<String> jl=new JList<>(model);//方法2；
	   JList<String> jl=new JList<>();
	   jl.setModel(model);                                //方法3；
	   JScrollPane jp=new JScrollPane(jl);
	   jp.setBounds(10,10,100,100);
	   c.add(jp);
	   
	   setVisible(true);
   }
   public static void main(String[] args) {
	new JlistDemo();
	
}
}
