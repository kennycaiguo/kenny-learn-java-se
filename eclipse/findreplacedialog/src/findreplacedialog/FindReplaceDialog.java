package findreplacedialog;

import java.awt.TextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
//只是一个窗口，没有其他函数
public class FindReplaceDialog{
public JDialog Dialog;
public JButton FindNext,Replace,ReplaceAll,Finish;//4个按钮
public JCheckBox MatchCase;//1个CheckBox
public JRadioButton Up,Down;//1组单选按钮(上下)
public ButtonGroup DirectionGroup;
public JLabel FindWhat,ReplaceWith,Direction;//3个label
public TextField FindText,ReplaceText;//2个文本区

public FindReplaceDialog(JFrame notepad){//构造函数
      Dialog=new JDialog(notepad,"Find And Replace...",false);/*
21          * 与EnsureDialog不同的是，这里的模式标志false使对话框始终处于notepad的上端，但点击notepad
22          * 时notepad会继续处于活动状态，对话框则变成不活动状态 注意！！！*/
       FindNext=new JButton("Find Next");//4个按钮实例
        Replace=new JButton("Replace");
        ReplaceAll=new JButton("Replace All");
        Finish=new JButton("Finish");
        MatchCase=new JCheckBox("Match Case",false);//1个CheckBox
        Down=new JRadioButton("Down",true);//1组单选
        Up=new JRadioButton("Up",false);
        FindWhat=new JLabel("Find What:");//3个label
        ReplaceWith=new JLabel("Replace With:");
        Direction=new JLabel("Direction:");
         FindText=new TextField("");//2个文本区
         ReplaceText=new TextField("");
         Dialog.setSize(380, 160);
         Dialog.setResizable(false);
         FindNext.setFocusable(false);//？
        Replace.setFocusable(false);
        ReplaceAll.setFocusable(false);
        MatchCase.setFocusable(false);
        Finish.setFocusable(false);
         Up.setFocusable(false);
         Down.setFocusable(false);
        DirectionGroup=new ButtonGroup();
         Dialog.setLayout(null);
         FindWhat.setBounds(10,12,80,22);
        ReplaceWith.setBounds(10,42,80,22);
        FindText.setBounds(95, 12, 160, 22);
         ReplaceText.setBounds(95, 42, 160, 22);
        FindNext.setBounds(265, 12, 98, 22);
         Replace.setBounds(265, 42, 98, 22);
        ReplaceAll.setBounds(265, 72, 98, 22);
         Direction.setBounds(10, 72, 80, 22);
        MatchCase.setBounds(6, 102, 98, 22);
         Down.setBounds(95, 72, 80, 22);
         Up.setBounds(175, 72, 80, 22);
         Finish.setBounds(265, 102, 98, 22);
         DirectionGroup.add(Up);//单选加入group
        DirectionGroup.add(Down);
       Dialog.add(FindWhat);
       Dialog.add(MatchCase);
         Dialog.add(FindText);
        Dialog.add(FindNext);
        Dialog.add(Direction);
         Dialog.add(ReplaceWith);
        Dialog.add(ReplaceText);
        Dialog.add(Replace);
         Dialog.add(ReplaceAll);
        Dialog.add(Finish);
        Dialog.add(Down);
        Dialog.add(Up);
    }
  public static void main(String[] args) {
	JFrame f=new JFrame("FindAndReplae");
			FindReplaceDialog frd=new FindReplaceDialog(f);
			frd.Dialog.setVisible(true);
 }
}
