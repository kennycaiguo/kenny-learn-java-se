package javanotepad;

/*
 * 最新进度：实现了文本查找功能
  注意：1<1>FileDialog的用法在jdk帮助文档里面找不到，必须在网上找
  1<2>.在打开一个文本文件并且显示了内容后，要将光标设置在文件开始的地方
  参考代码：area.setCaretPostion(0);
  
   2.记事本的撤销功能的实现比较复杂：
   <1.>创建UndoManager对象：UndoManager undomgr=new UndoManager();
   <2.>创建JTextArea的文档对象并且添加文档监听器
   area.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
								@Override
								public void undoableEditHappened(UndoableEditEvent e) {
									// TODO Auto-generated method stub
									
									undomgr.addEdit((e.getEdit()));								
								 }								
							});		
		<3>.为撤销菜单添加动作监听器
		undoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				undomgr.undo();
			}});
			
	3.记事本的删除功能比较有技巧：
	   利用JTextArea的.replaceSelection("");   函数将选中的文本替换为空字符串"".
	   
	   
	 4.实现选中文本是菜单可用：利用addMouseListener方法创建MouseAdapter因为MouseAdapter
	 只需要实现一个方法
	 area.addMouseListener(new MouseAdapter() {
 
			@Override
			public void mouseReleased(MouseEvent e) {
			 
					if(NotepadDemo.area.getSelectedText()!=null) {
						 
						 NotepadDemo.enableCutCopy();
					}
					else {
						 NotepadDemo.disableCutCopy(); 
					}
					  
 
			}
			
	5<1>.符串查找应该	具备这样的功能：从当前光标处开始查找
	首先获取光标的位置
	end=area.getCaretPosition()
	然后就是查找的代码...
	
	5<2>.字符串反向查找的技巧：找到了就将字符串变短因为lastIndexOf函数只会运行一次
	6(1).实现全部替换的功能的技巧1：利用while循环每找到一个就替换一个，一直到最后		
      代码如下：
       ReplaceAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					start=0;
					end=0;
					 findtext=FindText.getText();
					while( (start=NotepadDemo.area.getText().indexOf(findtext,end))!=-1){
						 NotepadDemo.area.setSelectionStart(start);
						 end=findtext.length()+start;
						 NotepadDemo.area.setSelectionEnd(end);
						 NotepadDemo.area.replaceSelection(ReplaceText.getText());
					}
				}
			});
	6(2)实现全部替换的功能的技巧2:先利用String类的replaceAll方法替换所有需要替换的内容然后利用JTextArea的
	setText方法重新设置文本内容(FindReplaceDialog类实现)
	参考代码
	ReplaceAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					findtext=FindText.getText();
					String content=NotepadDemo.area.getText();
					content=content.replaceAll(findtext, ReplaceText.getText());
					NotepadDemo.area.setText(content);
				}
			});
	7.关闭对话框(并不退出主程序)：Dialog.dispose();
	
	8.实现转到指定行的步骤：
	（1）获得总行数
	（2）获得需要转到的行号
	（3）获取行首和行尾
	    参考代码：
	    	//JTextArea起始行号是0，所以此处做减一处理
					int selectionStart = 0;
					int selectionEnd = 0;
					try {
							  selectionStart = JavaNotepad.area.getLineStartOffset(lineNum-1);
							  selectionEnd = JavaNotepad.area.getLineEndOffset(lineNum-1);
							
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
					//如果是不是最后一行，selectionEnd做减一处理，是为了使光标与选中行在同一行
					if(lineNum != totalLineCount){
						selectionEnd--;
					}
	（4）	设置光标到指定行的行首： JavaNotepad.area.setCaretPosition(selectionStart);//
	（5）   使文本域获得输入焦点： JavaNotepad.area.requestFocus(); //获得焦点
					
	9.在当前光标处插入时间的步骤：
	a.创建一个Date对象：Date d=new Date();
	b.创建一个SimpleDateFormat对象：SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    c.调用SimpleDateFormat的format方法获取时间字符串：String datestr=sdf.format(d);
    d.获取当前光标的位置：int pos=area.getCaretPosition();
    e.在获取当前光标的位置插入时间字符串area.insert(datestr,pos);
 */

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.BadLocationException;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.undo.UndoManager;

import javanotepad.FindReplaceDialog;
import javax_swing.FrameTool;
import javanotepad.JavaNotepad;
 
 class Swing_OnValueChanged implements DocumentListener {
     
	@Override
	public void insertUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		JavaNotepad.UpdateFrameTitle(JavaNotepad.f);
		
		
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		JavaNotepad.UpdateFrameTitle(JavaNotepad.f);
		 
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		// TODO Auto-generated method stub
		JavaNotepad.UpdateFrameTitle(JavaNotepad.f);
		
	}

}
 
  class GotoDialog{
	  public JDialog dlg;
	  public static JButton btnGoto,btnCancel;
	  public static JTextField gotoField;
	  public static JLabel lineNum;
	  
	  public GotoDialog(JFrame notepad) {
		  dlg=new JDialog(notepad,"转到指定行",false);
		  btnGoto =new JButton("转到");
		  btnCancel =new JButton("取消");
		  lineNum=new JLabel("输入行号");
		  gotoField =new JTextField(100);
		dlg.setBounds(notepad.getWidth()/2+100,notepad.getHeight()/2,380,140);		  
	    dlg.setResizable(false);
	    dlg.setLayout(null);
		lineNum.setBounds(13,4,80,25);
		
        gotoField.setBounds(13, 34, 300 ,25);
//	     
         btnGoto.setBounds(16, 64, 100, 25);
	     btnGoto.setFocusable(false);
	     btnCancel.setBounds(210, 64, 100, 25);
         btnCancel.setFocusable(false);
    btnGoto.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String line=gotoField.getText();
			if(line!=null ||!"".contentEquals(line)) {
					int totalLineCount = 	JavaNotepad.area.getLineCount();//获取总行数
					if(totalLineCount<=1) {
						return;
					}
					int lineNum=Integer.parseInt(line);
					 
					if(lineNum>=totalLineCount) {
						return;
					}
					
					//JTextArea起始行号是0，所以此处做减一处理
					int selectionStart = 0;
					int selectionEnd = 0;
					try {
							  selectionStart = JavaNotepad.area.getLineStartOffset(lineNum-1);
							  selectionEnd = JavaNotepad.area.getLineEndOffset(lineNum-1);
							
					} catch (BadLocationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					 
					//如果是不是最后一行，selectionEnd做减一处理，是为了使光标与选中行在同一行
					if(lineNum != totalLineCount){
						selectionEnd--;
					}
					 // JavaNotepad.area.requestFocus(); //获得焦点

//					 JavaNotepad.area.setSelectionStart(selectionStart);
//					 JavaNotepad.area.setSelectionEnd(selectionEnd);   如果使用了这两句，光标会停留在下载行的行尾。而记事本程序要求的是光标停留在指定行的行首
					 JavaNotepad.area.setCaretPosition(selectionStart);//设置光标到指定行的行首
					 JavaNotepad.area.requestFocus(); //获得焦点
					 
			}
		}
	});
    
    btnCancel.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			dlg.dispose();
		}
	});
	     dlg.add(lineNum);
	     dlg.add(gotoField);
	     dlg.add(btnGoto);
	     dlg.add(btnCancel);
	  }
  }
  
 /* /** 
   * 字体选择对话框。 
   */  
 class FontDialog extends JDialog {  
    
      private final JPanel contentPanel = new JPanel();  
      private JComboBox fontNameBox = null;  
      private JComboBox fontStyleBox = null;  
      private JComboBox fontSizeBox = null;  
      private JTextArea txtrHereIs = null;  
    
      private String fontName;  
      private String fontStyle;  
      private String fontSize;  
      private int fontSty;  
      private int fontSiz;  
      public Font font;
      
      /** 
       * Launch the application. 
       */  
 
      /** 
       * Create the dialog. 
       */  
      public FontDialog(JTextArea area) {  
          //setTitle("\u5B57\u4F53");  
      	setTitle("字体选择对话框");  
          setBounds(area.getWidth()/2+100, area.getHeight()/2, 483, 234);  
          getContentPane().setLayout(new BorderLayout());  
          setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE); 
          contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));  
          getContentPane().add(contentPanel, BorderLayout.CENTER);  
          contentPanel.setLayout(null);  
          {  
             // JLabel lblf = new JLabel("\u5B57\u4F53(F):");  
              JLabel lblf = new JLabel("字体(F):");  
              lblf.setBounds(0, 10, 54, 15);  
              contentPanel.add(lblf);  
          }  
          {  
              //JLabel lbly = new JLabel("\u5B57\u5F62(Y):");  
              JLabel lbly = new JLabel("字形(Y):");  
              lbly.setBounds(182, 10, 54, 15);  
              contentPanel.add(lbly);  
          }  
          {  
              JLabel lbls = new JLabel("大小(S):");  
              lbls.setBounds(315, 10, 54, 15);  
              contentPanel.add(lbls);  
          }  
          {  
              //JLabel label = new JLabel("\u663E\u793A\u6548\u679C:");  
              JLabel label = new JLabel("字体示例:");  
              label.setBounds(126, 82, 64, 15);  
              contentPanel.add(label);  
          }  
    
          Panel panel = new Panel();  
          panel.setBounds(196, 40, 228, 113);  
          contentPanel.add(panel);  
          panel.setLayout(null);  
          {  
              txtrHereIs = new JTextArea();  
              txtrHereIs.setBounds(39, 38, 177, 44);  
              txtrHereIs  .setText("\u8FD9\u91CC\u663E\u793A\u9884\u89C8\r\nHere is the preview");  
              panel.add(txtrHereIs);  
          }  
          {  
              fontNameBox = new JComboBox();  
              fontNameBox.setBounds(49, 7, 123, 21);  
              contentPanel.add(fontNameBox);  
              fontNameBox.addItemListener(new ItemListener() {  
                  public void itemStateChanged(ItemEvent itemevent) {  
                      fontName = (String) itemevent.getItem();  
                     // System.out.println(fontName);  
    
                      // change preview  
                      Font f = new Font(fontName, fontSty, fontSiz);  
                      txtrHereIs.setFont(f);  
                  }
           });  
         }  
          {  
              fontStyleBox = new JComboBox();  
              fontStyleBox.setBounds(232, 7, 73, 21);  
              contentPanel.add(fontStyleBox);  
              fontStyleBox.addItemListener(new ItemListener() {  
                  public void itemStateChanged(ItemEvent itemevent) {  
                      fontStyle = (String) itemevent.getItem();  
                      fontSty = getFontStyleByCnName(fontStyle);  
                      // change preview  
                      Font f = new Font(fontName, fontSty, fontSiz);  
                      txtrHereIs.setFont(f);  
                  }  
              });  
          }  
          {  
              fontSizeBox = new JComboBox();  
              fontSizeBox.setBounds(379, 7, 78, 21);  
              contentPanel.add(fontSizeBox);  
              fontSizeBox.addItemListener(new ItemListener() {  
                  public void itemStateChanged(ItemEvent itemevent) {  
                      fontSize = (String) itemevent.getItem();  
                      fontSiz = Integer.parseInt(fontSize);  
    
                      // change preview  
                      Font f = new Font(fontName, fontSty, fontSiz);  
                      txtrHereIs.setFont(f);  
                  }  
              });  
          }  
          {  
              JPanel buttonPane = new JPanel();  
              buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));  
              getContentPane().add(buttonPane, BorderLayout.SOUTH);  
              {  
                  JButton okButton = new JButton("\u786E\u5B9A");  
                  okButton.addActionListener(new ActionListener() {  
                      public void actionPerformed(ActionEvent actionevent) {  
                          int fontSty = getFontStyleByCnName(fontStyle);  
                          int fontSiz = Integer.parseInt(fontSize);  
                          
                         area.setFont(new Font(fontName, fontSty, fontSiz));
                         
                      }
                 });  
                  okButton.setActionCommand("OK");  
                  buttonPane.add(okButton);  
                  getRootPane().setDefaultButton(okButton);  
              }  
              {  
                  JButton cancelButton = new JButton("\u53D6\u6D88");  
                  cancelButton.setActionCommand("Cancel");  
                  buttonPane.add(cancelButton);  
                  cancelButton.addActionListener(new ActionListener() {  
                      public void actionPerformed(ActionEvent actionevent) {  
                          FontDialog.this.dispose();  
                      }  
                  });  
              }  
          }  
    
          // 初始化字体名称  
          GraphicsEnvironment ge = GraphicsEnvironment  
                  .getLocalGraphicsEnvironment();  
          String[] fontNames = ge.getAvailableFontFamilyNames();  
          fontNameBox.setModel(new DefaultComboBoxModel(fontNames));  
          // 初始化字体样式  
          String[] fontStyles = { "常规", "斜体", "粗体", "粗斜体" };  
          fontStyleBox.setModel(new DefaultComboBoxModel(fontStyles));  
          // 初始化字体大小  
          String[] fontSizes = { "8", "9", "10", "11", "12", "14", "16", "18",  
                  "20", "22", "24", "26", "28", "36", "48", "72" };  
          fontSizeBox.setModel(new DefaultComboBoxModel(fontSizes));  
          //System.out.println("finish.");  
    
          fontSizeBox.setSelectedIndex(4);  
          fontStyle = (String) fontStyleBox.getSelectedItem();  
          fontSize = (String) fontSizeBox.getSelectedItem();  
          fontSty = getFontStyleByCnName(fontStyle);  
          fontSiz = Integer.parseInt(fontSize);  
      }  
    
      public static int getFontStyleByCnName(String fontStyle) {  
          if (fontStyle.equals("常规")) {  
              return Font.PLAIN;  
          }  
          if (fontStyle.equals("斜体")) {  
              return Font.ITALIC;  
          }  
          if (fontStyle.equals("粗体")) {  
              return Font.BOLD;  
          }  
          if (fontStyle.equals("粗斜体")) {  
              return Font.BOLD + Font.ITALIC;  
          }  
          return -1;  
      }  
   
  }  
  
  class FindReplaceDialog{
	 public JDialog Dialog;
	 public static JButton FindNext,Replace,ReplaceAll,Finish;//4个按钮
	 public static JCheckBox MatchCase;//1个CheckBox
	 public static JRadioButton Up,Down;//1组单选按钮(上下)
	 public static ButtonGroup DirectionGroup;
	 public static JLabel FindWhat,ReplaceWith,Direction;//3个label
	 public static TextField FindText,ReplaceText;//2个文本区
     public   String findtext,sourstr;
        int start=0;
		int end=0;
		int fromlastindex=0; 
	 public FindReplaceDialog(JFrame notepad){//构造函数
	       Dialog=new JDialog(notepad,"查找和替换...",false);/*
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
	          //Dialog.setSize(380, 160);
	          Dialog.setBounds(notepad.getWidth()/2+100,notepad.getHeight()/2,380,180);
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
	         fromlastindex=JavaNotepad.area.getText().length();
	         sourstr=JavaNotepad.area.getText();
	         FindNext.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					
					  findtext=FindText.getText();
					 
					 if(findtext.length()!=0) {
						
						 end=JavaNotepad.area.getCaretPosition();
						 if(Down.isSelected()) {
							 if( (start=JavaNotepad.area.getText().indexOf(findtext,end))!=-1){
								 JavaNotepad.area.setSelectionStart(start);
								 end=findtext.length()+start;
								 JavaNotepad.area.setSelectionEnd(end);
								 JavaNotepad.area.setSelectedTextColor(Color.BLUE);
								 if(end==JavaNotepad.area.getText().lastIndexOf(findtext)+findtext.length()) {
									 JOptionPane.showMessageDialog(null,"已经到达文件末尾，可以尝试向上查找！！！");
								 }
								 // start=NotepadDemo.area.getText().indexOf(findtext,end);
								 
							 }
						 }else if(Up.isSelected()) {
							 //反向查找的技巧：找到了就将字符串变短因为lastIndexOf函数只会运行一次
							 if( (start=sourstr.lastIndexOf(findtext,fromlastindex))!=-1){
								 JavaNotepad.area.setSelectionStart(start); 
								 end=findtext.length()+start;
								 JavaNotepad.area.setSelectionEnd(end);
								 JavaNotepad.area.setSelectedTextColor(Color.BLUE);
								 sourstr=sourstr.substring(0, start-1);
								 
							 }else {
								 JOptionPane.showMessageDialog(null,"已经到达文件头，可以尝试向下查找！！！");
							 }

						 }
						
					 }
				}
			});
	         
	         Replace.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if( ReplaceText.getText()!="") {
						JavaNotepad.area.replaceSelection(ReplaceText.getText());
					}
				}
			});
	         
	         ReplaceAll.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					findtext=FindText.getText();
					String content=JavaNotepad.area.getText();
					content=content.replaceAll(findtext, ReplaceText.getText());
					JavaNotepad.area.setText(content);
				}
			});
	         Finish.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					Dialog.dispose();
				}
			});
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
  }
  
public class JavaNotepad {
	public static JFrame f=new JFrame("Java记事本");
	static JMenuBar  bar=new JMenuBar();
 
	JMenu fileMenu =new JMenu("文件");
	JMenu editMenu =new JMenu("编辑");
	JMenu formatMenu =new JMenu("格式");
	JMenu helpMenu =new JMenu("帮助");
	 
		
	JMenuItem newMenu=new JMenuItem("新建");
	JMenuItem openMenu=new JMenuItem("打开");
	JMenuItem saveMenu=new JMenuItem("保存");
	JMenuItem saveAsMenu=new JMenuItem("另存为");
	
	JMenuItem closeMenu=new JMenuItem("退出");
	//JMenuItem helpMenu1=new JMenuItem("查看帮助");
	JMenuItem aboutMenu=new JMenuItem("关于本程序");
	
	 JMenuItem undoMenu=new JMenuItem("撤销");
	 static JMenuItem cutMenu=new JMenuItem("剪切");
	 static JMenuItem copyMenu=new JMenuItem("复制");
	 static JMenuItem pasteMenu=new JMenuItem("粘贴"); 
	static JMenuItem deleteMenu=new JMenuItem("删除"); 
	JMenuItem findMenu=new JMenuItem("查找"); 
	JMenuItem replaceMenu=new JMenuItem("替换"); 
	JMenuItem gotoMenu=new JMenuItem("转到"); 
	JMenuItem selectAllMenu=new JMenuItem("全选"); 
	JMenuItem dateTimeMenu=new JMenuItem("时间/日期"); 
	
	JMenuItem fontMenu=new JMenuItem("字体"); 
	JMenuItem colorMenu=new JMenuItem("颜色"); 
	
	
	 
	public static JTextArea area=new JTextArea(30,20);
	
	public void initNotepad() {
		area.setText("");
		String title="无标题文档-"+"Java记事本";
		 f.setTitle(title);
		area.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//super.keyPressed(e);
				undoMenu.setEnabled(true);
				
				}
		});
		area.getDocument().addDocumentListener(new Swing_OnValueChanged ());
		area.addMouseListener(new MouseAdapter() {
 
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
//				JOptionPane.showMessageDialog(null, area.getSelectedText());
 
					if(JavaNotepad.area.getSelectedText()!=null) {
						 
						 JavaNotepad.enableCutCopyDelete();
					}
					else {
						 JavaNotepad.disableCutCopyDelete(); 
					}
					  
			}
		});

		 
		
		newMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String content=area.getText();
				if(content.length()==0) {
					
					String title="无标题文档-"+"Java记事本";
					 
					f.setTitle(title);
				}else {
					int option=JOptionPane.showConfirmDialog(null, "保存文件？", "保存提示", JOptionPane.YES_NO_CANCEL_OPTION); 
				       switch(option) {
				    	   case 0:
				    		   String filetitle=f.getTitle();
								String[]parts=filetitle.split("-");
								String savefilename=parts[0];
								File savefile=new File(savefilename);
								FileOutputStream fos;
								try {
									fos = new FileOutputStream(savefile);
									OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
									osw.write(area.getText().replaceAll("\n", "\r\n"));
									osw.close();
									
								} catch (IOException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}finally {
									area.setText("");
									String title="无标题文档-"+"Java记事本";
									 f.setTitle(title);
								}
								
				    		   break;
				    	   case 1:
				    		   area.setText("");
				    		   String title="无标题文档-"+"Java记事本";
								 
								f.setTitle(title);
				    		   break;
				    	   case 2:
				    			 break;
				       }
				}
				area.getFocusListeners();
				
			}});
		//如何解决打开对话框点击取消出现空指针异常
		openMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(area.getText().length()!=0) {
					int option=JOptionPane.showConfirmDialog(null, "保存文件?","保存提示",JOptionPane.YES_NO_CANCEL_OPTION);
				    switch(option) {
				    	case 0:
				    		saveFile();
				    		doFileOpen();
				    		break;
				    	case 1:
				    		doFileOpen();
				    		break;
				    	case 2:
				    		break;
				    }
				}else {
					doFileOpen();
				}
 
 }});
		saveMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				   saveFile();
				}
	}); 
		
		saveAsMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				saveFileWithDlg();
			}});
 
		
		closeMenu.addActionListener(new ActionListener() {
            @Override
			public void actionPerformed(ActionEvent e) {
            	doClose();
			}
		});
		UndoManager undomgr=new UndoManager();
		area.getDocument().addUndoableEditListener(new UndoableEditListener() {
			
								@Override
								public void undoableEditHappened(UndoableEditEvent e) {
									// TODO Auto-generated method stub
									
									undomgr.addEdit((e.getEdit()));								
								 }								
							});		
		
	undoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				undomgr.undo();
			}});
		cutMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.cut();
				pasteMenu.setEnabled(true);
				undoMenu.setEnabled(true);
			}});
		 copyMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.copy();
				pasteMenu.setEnabled(true);
			}});
		 
		 pasteMenu.addActionListener(new ActionListener() {
			 
			 @Override
			 public void actionPerformed(ActionEvent e) {
				 // TODO Auto-generated method stub
				 area.paste();
			 }});
		 
		 deleteMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				  area.replaceSelection("");
			}});
		 
		 findMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindReplaceDialog  frd=new FindReplaceDialog(f);
				frd.ReplaceWith.setVisible(false);
				frd.ReplaceText.setVisible(false);
				frd.Replace.setVisible(false);
				frd.ReplaceAll.setVisible(false);
				frd.Finish.setVisible(false);
				frd.Dialog.setVisible(true);
			}
		});
		 
		 replaceMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				FindReplaceDialog  frd=new FindReplaceDialog(f);
				frd.Dialog.setVisible(true);
				
			}
		});
		 
		gotoMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				GotoDialog gdlg=new GotoDialog(f);
				gdlg.dlg.setVisible(true);
			}
		});
		 
		selectAllMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				area.selectAll();
				cutMenu.setEnabled(true);
				copyMenu.setEnabled(true);
				
			}
		}); 
		 
		dateTimeMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Date d =new Date();
				SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			    String datestr=sdf.format(d);
			   // JOptionPane.showMessageDialog(null,datestr);
			    int pos =area.getCaretPosition();
			    area.insert(datestr, pos);
			}
		});
		
		fontMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 FontDialog fdlg=new FontDialog(area);
				 fdlg.setVisible(true);
				 
			}
		});
		
		colorMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			Color c=JColorChooser.showDialog(null, "请选择颜色", Color.BLACK);
  
				area.setForeground(c);
			
		}
	});
		
		aboutMenu.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				StringBuilder sb =new StringBuilder();
				sb.append("记事本程序Java版本1.0"+"\r\n");
				sb.append("作者：Kenny Cai"+"\r\n");
				sb.append("邮箱：Kennycai8888@outlook.com"+"\r\n");
				sb.append("版权所有，违版必究"+"\r\n");
				JOptionPane.showMessageDialog(null, sb.toString(),"关于本程序",JOptionPane.OK_OPTION);
				
			}
		});
		
		fileMenu.add(newMenu);
		fileMenu.add(openMenu);
		fileMenu.add(saveMenu);
		fileMenu.add(saveAsMenu);
		//fileMenu.add(switchMenu);
		fileMenu.add(closeMenu);
		
		editMenu.add(undoMenu);
		editMenu.add(cutMenu);
		editMenu.add(copyMenu);
		editMenu.add(pasteMenu);
		editMenu.add(deleteMenu);
		editMenu.add(findMenu);
		editMenu.add(replaceMenu);
		editMenu.add(gotoMenu);
		editMenu.add(selectAllMenu);
		editMenu.add(dateTimeMenu);
		
		undoMenu.setEnabled(false);
		cutMenu.setEnabled(false);
		copyMenu.setEnabled(false);
		 
		deleteMenu.setEnabled(false);
		
		
		formatMenu.add(fontMenu);
		formatMenu.add(colorMenu);
		
		//helpMenu.add(helpMenu1);
		helpMenu.add(aboutMenu);
		
		
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(formatMenu);
		bar.add(helpMenu);
		f.add(bar,BorderLayout.NORTH);
		JScrollPane scrollpane=new JScrollPane(area);
		scrollpane.setHorizontalScrollBarPolicy(
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				scrollpane.setVerticalScrollBarPolicy(
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
				 
		f.add(scrollpane);
		FrameTool.CenterFrame(f, 600, 500);
		f.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				doClose();
			}
		});
		
		f.setVisible(true);
	}
	
	public static void UpdateFrameTitle(JFrame f) {
		String title=f.getTitle();
		if(!title.contains("(未保存)")) title+="(未保存)";
		f.setTitle(title);
		
	}
	
	public static void saveFileWithDlg() {
		FileDialog fd=new FileDialog(f, "保存文件",FileDialog.SAVE);
        fd.setVisible(true);
        if(fd.getFile()!=null) {//如果这里不先判断一下，就会出现空指针异常
        	String path=fd.getDirectory();
    		String filename= fd.getFile();
    		String title=path+filename+"-"+f.getTitle(); 
    		f.setTitle(title);
    		File file=new File(path,filename);
    		try {
    			FileOutputStream fos=new FileOutputStream(file);
    			OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
    			osw.write(area.getText().replaceAll("\n", "\r\n"));
    			osw.close();
    			f.setTitle(path+filename+"-Java记事本");
    		} catch (IOException e1) {
    			// TODO Auto-generated catch block
    			e1.printStackTrace();
    		}
		}
		
	}
	
	public static void enableCutCopyDelete() {
		cutMenu.setEnabled(true);
		copyMenu.setEnabled(true);
		deleteMenu.setEnabled(true);
	}
	public static void disableCutCopyDelete() {
		cutMenu.setEnabled(false);
		copyMenu.setEnabled(false);
		deleteMenu.setEnabled(false);
	}
	
	 public static void doClose() {
		 if(area.getText().length()!=0) {
	    	    int option=JOptionPane.showConfirmDialog(null, "保存文件？", "退出保存提示", JOptionPane.YES_NO_CANCEL_OPTION); 
		       switch(option) {
		    	   case 0:
		    		   String filetitle=f.getTitle();
						String[]parts=filetitle.split("-");
						String savefilename=parts[0];
						if(savefilename.equals("无标题文档")) {
							saveFileWithDlg();
						}else {
							
							File savefile=new File(savefilename);
							FileOutputStream fos;
							try {
								fos = new FileOutputStream(savefile);
								OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
								osw.write(area.getText().replaceAll("\n", "\r\n"));
								osw.close();
								
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							} 
							
							System.exit(0);
						}
		    		   break;
		    	   case 1:
		    		   System.exit(0);
		    	   case 2:
		    		   break;
		       }
	    }else {
	    	
	    	System.exit(0);
	    }
	    	
	}
	 
	public static void saveFile() {
		String filetitle=f.getTitle();
		String[]parts=filetitle.split("-");
		String savefilename=parts[0];
		
		if(savefilename.equals("无标题文档")) {
						saveFileWithDlg();
			}else {
				File savefile=new File(savefilename);
				//JOptionPane.showMessageDialog(null, savefile.getAbsolutePath());
				  
					FileOutputStream fos;
					try {
						fos = new FileOutputStream(savefile);
						OutputStreamWriter osw=new OutputStreamWriter(fos,"gbk");
						osw.write(area.getText());
						osw.close();
						f.setTitle(savefilename+"-Java记事本");
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			}
	}
	
	public static void doFileOpen() {
		FileDialog fd=new FileDialog(f, "选择要打开的文件",FileDialog.LOAD);
		fd.setVisible(true);
		if(fd.getFile()!=null) {//如果这里不先判断一下，就会出现空指针异常
			String path=fd.getDirectory();
			String filename= fd.getFile();
			String title=path+filename+"-"+"Java记事本";
			f.setTitle(title);
			File file=new File(path,filename);
			try {
				FileInputStream fis=new FileInputStream(file);
				InputStreamReader isr=new InputStreamReader(fis,"gbk");
      			BufferedReader bfr =new BufferedReader(isr);
				String line=null;
				String content="";
				while((line=bfr.readLine())!=null) {
					content+=line+"\r\n";
				}
				area.setText(content);
				area.setLineWrap(true);  //实现自动换行
				area.setWrapStyleWord(true);
				area.setCaretPosition(0);
				bfr.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
    public static void main(String[] args) {
    	new JavaNotepad().initNotepad();
	}
}

